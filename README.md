# HtmlGenerator

This project is a base that I have used to generate an HTML page based on a Json File in a project on Github. The Java program downloads the project from Github based on input parameters. It retrieves the logo, image and other information from the Github project and posts this into a directory structure that is predetermined. In addition, the developer's description and "Brandcolor" are extracted to be posted on the page. It builds a web page that includes photos and logo that has been extracted. It then takes the project and moves this to a project Storage.

This project is not initially complete, but can be adapted to the needs of the individual. As of today, the project is reducing Homey projects and all Json parsing is based on this project type format.
##Run parameters

&nbsp;&nbsp;&nbsp;&nbsp;HtmlGenerator -g <GitHub file\> -p <Project name\> -f <GroupId+ArtifactId+version\>

###Example

***My test project WizBulbs på GitHub.***

&nbsp;&nbsp;&nbsp;&nbsp;HtmlGenerator -g no.jib.WizBulbs/archive/refs/tags/2.5.0.zip -p wizbulbs -f no.jib.WizBulbs-2.5.0

##Setup
The Java program is configurable when it comes to the pre -set directory structure. Configuration is done via the 'htmlgenerator.properties' in directory named config under root directory for the app.


## Remarks
This app is experimental and may therefore contain errors and omissions. The app is not based an official library from Wiz and all use of the app is at your own risk.

## Change log



# Licens
[MIT](GitHub.com)

