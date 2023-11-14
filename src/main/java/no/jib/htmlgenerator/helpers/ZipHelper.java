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

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.IOException;

public class ZipHelper {

    public void getAppJson(String zipfile,String base) {
        try {
            new ZipFile(zipfile).extractFile(String.format("%s/app.json",base), "zipwork");
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAppLogo(String zipfile,String base) {
        try {
            new ZipFile(zipfile).extractFile(String.format("%s/assets/icon.svg",base), "zipwork");
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAppPicture(String zipfile,String base) {
        try {
            new ZipFile(zipfile).extractFile(String.format("%s/assets/images/large.png",base), "zipwork");
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }
    }

    public void freeFile(String zipfil) {
        try {
            new ZipFile(zipfil).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
