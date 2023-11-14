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

import org.json.JSONObject;

public class AppObject {
    private String id = new String();
    private String name = new String();
    private String aname = new String();
    private String description = new String();
    private String version = new String();
    private String appcolor = new String();
    private String homepage = new String();
    private String bugs = new String();
    private String source = new String();
    public void buildAppObject(String jsonstring) {
        JSONObject obj = new JSONObject(jsonstring);
        id = obj.getString("id");
        version = obj.getString("version");
        appcolor = obj.getString("brandColor");
        homepage = obj.getString("homepage");
        source = obj.getString("source");
        aname = obj.getJSONObject("author").getString("name");
        description = obj.getJSONObject("description").getString("en");
        name = obj.getJSONObject("name").getString("en");
        bugs = obj.getJSONObject("bugs").getString("url");
    }

    public String getId() {
        return id;
    }

    public String getAppcolor() {
        return appcolor;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBugs() {
        return bugs;
    }

    public String getSource() {
        return source;
    }

    public String getAuthor() {
        return aname;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }
}
