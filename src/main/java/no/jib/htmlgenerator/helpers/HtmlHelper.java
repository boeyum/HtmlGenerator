package no.jib.htmlgenerator.helpers;
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

public class HtmlHelper {

    public String startBody(String bgcolor) {
        return String.format("\t<body style=\"background:%s\">\n",bgcolor);
    }

    public String endBody() {
        return "\t</body>\n";
    }

    public String setLogo(String logoname) {
        String retStr = new String();
        retStr = "\t\t<div class=\"xcontainer\">\n";
        retStr += String.format("\t\t\t<img width=\"100px\" src=\"%s\" alt=\"\">\n",logoname);
        retStr += "\t\t\t<br><br>\n\t\t</div>\n";
        return retStr;
    }

    public String setPicture(String pictname, String name, String version) {
        String retStr = new String();
        retStr = "\t\t<div class=\"container\">\n";
        retStr += String.format("\t\t\t<img src=\"%s\" alt=\"%s\" ",pictname,name);
        retStr += "style=\"width:50%;\">\n";
        retStr += String.format("\t\t\t<div class=\"centered\"><h1>%s</h1><br><h3>Version: %s</h3></div>\n",name,version);
        retStr += "\t\t\t<br><br>\n\t\t</div>\n";
        return retStr;
    }

    public String setDescription(String text) {
        String retStr = new String();
        retStr = "\t\t<center>\n\t\t<div class=\"tcontainer\">\n";
        retStr += "\t\t\t<p><h3 style=\"color:white;text-align:center;\">\n";
        retStr += "\t\t\t" + text + "\n";
        retStr += "\t\t\t</h3></p>\n";
        retStr += "\t\t</div>\n\t\t</center>\n";
        return retStr;
    }

    public String startDeveloper() {
        return "\t\t<div>\n" +
                "\t\t<center>\n" +
                "\t\t\t<br><br><p><h2>DEVELOPER INFORMATION</h2></p><br>\n" +
                "\t\t\t<table width=\"60%\">\n";
    }

    public String endDeveloper() {
        return "\t\t\t</table>\n" +
                "\t\t\t</center>\n" +
                "\t\t</div>\n";
    }

    public String lineFeed() {
        return "<br><br>\n";
    }

    public String writeFooter(String app) {
        String retStr = new String();
        retStr = "\t\t<div class=\"footer\">\n" +
                "\t\t\t<center>\n" +
                "\t\t\t<table width=\"80%\">\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th width=40%><h2>The App</h2></th>\n" +
                "\t\t\t\t\t<th width=30%><h2>Download</h2></th>\n" +
                "\t\t\t\t\t<th width=30%><h2>Donate</h2></th>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th width=40%>The are a free app share for the Homey community.<br>See the source code for licensing.</th>\n";
        retStr += "\t\t\t\t\t<th width=30%><button ";
        retStr += String.format("onclick=\"downloadfunk('%s')\"",app);
        retStr += " type=\"button\">DOWNLOAD</button></th>\n";
        retStr += "\t\t\t\t\t<th width=30%><button ";
        retStr += String.format("onclick=\"donatefunk('%s')\"",app);
        retStr += " type=\"button\">DONATE</button></th>\n";
        retStr += "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<br><br>\n" +
                "\t\t\t<p>This page are made by a automatic web page generator. Design and developed by: Jan-Ivar B&oslash;yum.\n" +
                "\t\t\t</center>\n" +
                "\t\t</div>\n";
        return retStr;
      }

    public String writeAuthor(String text) {
        String retStr = new String();
        retStr = "\t\t\t\t<tr>\n";
        retStr += "\t\t\t\t\t<td width=\"30%\"><h4>Author</h4></td>\n";
        retStr += String.format("\t\t\t\t\t<td><b><i>%s</i></b></td>\n",text);
        retStr += "\t\t\t\t</tr>\n";
        return retStr;
    }

    public String writeHomepage(String text) {
        String retStr = new String();
        retStr = "\t\t\t\t<tr>\n";
        retStr += "\t\t\t\t\t<td width=\"30%\"><h4>Homepage</h4></td>\n";
        retStr += String.format("\t\t\t\t\t<td><b><i>%s</i></b></td>\n",text);
        retStr += "\t\t\t\t</tr>\n";
        return retStr;
    }

    public String writeBugs(String text) {
        String retStr = new String();
        retStr = "\t\t\t\t<tr>\n";
        retStr += "\t\t\t\t\t<td width=\"30%\"><h4>Bugs</h4></td>\n";
        retStr += String.format("\t\t\t\t\t<td><b><i>%s</i></b></td>\n",text);
        retStr += "\t\t\t\t</tr>\n";
        return retStr;
    }

    public String writeSource(String text) {
        String retStr = new String();
        retStr = "\t\t\t\t<tr>\n";
        retStr += "\t\t\t\t\t<td width=\"30%\"><h4>Source</h4></td>\n";
        retStr += String.format("\t\t\t\t\t<td><b><i>%s</i></b></td>\n",text);
        retStr += "\t\t\t\t</tr>\n";
        return retStr;
    }
}
