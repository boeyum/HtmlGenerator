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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileHelper {

    public boolean downloadProject(String FILE_URL, String zipfile) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream())) {
            FileOutputStream fileOutputStream = new FileOutputStream(zipfile);
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Download failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean moveFile(String fra, String til) {
        boolean fileMoved = true;
        try {
            Files.move(Paths.get(fra), Paths.get(til), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Move file failed: " + e.getMessage());
            fileMoved = false;
        }
        return fileMoved;
    }

    public boolean renameFile(String fra, String til) {
        File file = new File("fra");
        File file2 = new File("til");
        boolean success = file.renameTo(file2);
        if(!success) {
            System.out.println("Rename file failed!");
        }
        return success;
    }

    public boolean copyFile(String fra, String til) {
        Path copied = Paths.get(til);
        Path originalPath = Paths.get(fra);
        try {
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Copy file failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean fileDelete(String fname) {
        File f = new File(fname);
        return f.delete();
    }

    public String readJsonString(String fname) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fname);
            byte[] buffer = new byte[10];
            StringBuilder sb = new StringBuilder();
            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
            fis.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Read JSON failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Read JSON failed: " + e.getMessage());
        }
        return null;
    }
}
