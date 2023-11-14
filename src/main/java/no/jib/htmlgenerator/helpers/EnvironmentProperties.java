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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {

    static Properties props;
    static long adds = 0;

    public boolean defExist() {
        File propsFile = new File("config/htmlgenerator.properties");
        return propsFile.exists();
    }

    public void fileLoad() throws IOException {
        File propsFile = new File("config/htmlgenerator.properties");
        adds = propsFile.lastModified();
        props = new Properties();
        FileInputStream fis = new FileInputStream(propsFile);
        props.load(fis);
        fis.close();
    }

    public boolean checkForUpdate() {
        File propsFile = new File("config/htmlgenerator.properties");
        if(adds < propsFile.lastModified()) {
            return true;
        }
        return false;
    }

    public String readConfigurationParameter(String key) {
        if(checkForUpdate()) {
            try {
                fileLoad();
            } catch (IOException e) {
                return null;
            }
        }
        return props.getProperty(key);
    }
}
