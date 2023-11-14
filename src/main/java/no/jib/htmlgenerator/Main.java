package no.jib.htmlgenerator;
/*
 * Project: HtmlGenerator
 * Version: 1.x
 *
 * Copyright 2023 Jan-Ivar B�yum

 * Copyright 2021-2023 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the “Software”), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import no.jib.htmlgenerator.domain.AppObject;
import no.jib.htmlgenerator.domain.HtmlConstants;
import no.jib.htmlgenerator.helpers.EnvironmentProperties;
import no.jib.htmlgenerator.helpers.FileHelper;
import no.jib.htmlgenerator.helpers.HtmlHelper;
import no.jib.htmlgenerator.helpers.ZipHelper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String ACCESSLOG_FILE = "logs/basic_archive_rest_yyyy_mm_dd.log";

    private static EnvironmentProperties EP = new EnvironmentProperties();
    private static AppObject AO = new AppObject();
    private static ZipHelper ZH = new ZipHelper();
    private static HtmlConstants HC = new HtmlConstants();
    private static HtmlHelper HH = new HtmlHelper();
    private static FileHelper FH = new FileHelper();
    private static String fileGit = new String();
    private static String appname = new String();
    private static String vername = new String();
    private static int data_g = 0;
    private static int data_p = 0;
    private static int data_f = 0;
    private static String workpath = new String();
    private static String imagepath = new String();
    private static String htmlpath = new String();
    private static String downpath = new String();

    public static void main(String[] args) {

        int nextString = 0;

        for (String s: args) {
            if(s.compareToIgnoreCase("-g") == 0) {
                nextString = 1;
            }
            else if(s.compareToIgnoreCase("-p") == 0) {
                nextString = 2;
            }
            else if(s.compareToIgnoreCase("-f") == 0) {
                nextString = 3;
            }
            else if(s.compareToIgnoreCase("-h") == 0) {
                System.out.println("\n---------------------------------------------------------------------------------------------");
                System.out.println("Syntax: HtmlGenerator -g <Git file download> -p <project name> -f fullpath or -h");
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.exit(0);
            }
            else {
                if(nextString == 1) {
                    fileGit = s;
                    nextString = 0;
                    data_g = 1;
                }
                else if(nextString == 2) {
                    appname = s;
                    nextString = 0;
                    data_p = 1;
                }
                else if(nextString == 3) {
                    vername = s;
                    nextString = 0;
                    data_f = 1;
                }
            }
        }
        if((data_g == 0) || (data_p == 0) || (data_f == 0)) {
            System.out.println("\n-------------------------------------------------------------------------------------------");
            System.out.println("  Not valid startup statement. Check the manual or use HtmlGenerator -h ");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.exit(0);
        }
        if(EP.defExist()) {
            workpath = EP.readConfigurationParameter("workpath");
            htmlpath = EP.readConfigurationParameter("htmlpath");
            imagepath = EP.readConfigurationParameter("imagepath");
            downpath = EP.readConfigurationParameter("downloadpath");
        } else {
            workpath = "zipwork";
            htmlpath = "html";
            imagepath = "html/images";
            downpath = "apps";
        }
        String workdfile = String.format("%s/%s.zip",workpath,appname);
        if(!FH.downloadProject(fileGit,workdfile)) {
            System.out.println("Could not download: " + fileGit);
            System.out.println("\n-------------------------------------------------------------------------------------------");
            System.out.println("                         Unable to download from GitHub");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.exit(-1);
        }
        ZH.getAppJson(workdfile,vername);
        AO.buildAppObject(FH.readJsonString(String.format("%s/%s/app.json",workpath,vername)));
        String htmlfile = String.format("%s/%s.html",htmlpath,appname);
        String iconfile = String.format("%s/%s.svg",imagepath,appname);
        String imagefile = String.format("%s/%s.png",imagepath,appname);
        String downlfile = String.format("%s/%s.zip",downpath,appname);
        ZH.getAppLogo(workdfile,vername);
        ZH.getAppPicture(workdfile,vername);
        FH.moveFile(String.format("%s/%s/assets/icon.svg",workpath,vername),iconfile);
        FH.moveFile(String.format("%s/%s/assets/images/large.png",workpath,vername),imagefile);
        ZH.freeFile(workdfile);

        File file = new File(htmlfile);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(HC.HtmlStart());
            fr.write(HH.startBody(AO.getAppcolor()));
            fr.write(HH.setLogo(String.format("images/%s.svg",appname)));
            fr.write(HH.setPicture(String.format("images/%s.png",appname),AO.getName(),AO.getVersion()));
            fr.write(HH.setDescription(AO.getDescription()));
            fr.write(HH.startDeveloper());
            fr.write(HH.writeAuthor(AO.getAuthor()));
            if(AO.getHomepage() != null) {
                fr.write(HH.writeHomepage(AO.getHomepage()));
            }
            if(AO.getBugs() != null) {
                fr.write(HH.writeBugs(AO.getBugs()));
            }
            if(AO.getSource() != null) {
                fr.write(HH.writeSource(AO.getSource()));
            }
            fr.write(HH.endDeveloper());
            fr.write(HH.writeFooter(appname));
            fr.write(HH.endBody());
            fr.write(HC.HtmlEnd());
        } catch (IOException e) {
            System.out.println("File access error: " + e.getMessage());
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("File close error: " + e.getMessage());
            }
        }
        FH.copyFile(String.format("%s/%s.zip",workpath,appname),downlfile);
        FH.fileDelete(String.format("%s/%s.zip",workpath,appname));
        FH.fileDelete(String.format("%s/%s",workpath,vername));
        System.out.println(String.format("APP %s successfully added to the repository.",appname));
        System.exit(0);
    }

}