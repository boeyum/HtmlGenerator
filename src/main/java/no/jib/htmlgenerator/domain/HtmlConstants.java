package no.jib.htmlgenerator.domain;
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

public class HtmlConstants {

    public String HtmlStart() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>HC Store</title>\n" +
                "\t\t<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" +
                "\t\t<meta content=\"Alternative Homey App store\" name=\"keywords\">\n" +
                "\t\t<meta content=\"Alternative Homey App store\" name=\"description\">\n" +
                "\t\n" +
                "\t\t<!-- Customized Stylesheet -->\n" +
                "\t\t<link href=\"css/happs.css\" rel=\"stylesheet\">\n" +
                "\t</head>\n";
    }

    public String HtmlEnd() {
        return "</html>";
    }
}
