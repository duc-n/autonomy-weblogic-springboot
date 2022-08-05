@echo off
mvn com.oracle.weblogic:weblogic-maven-plugin:deploy
-Dsource=C:\Dev\weblogic_springboot\target\autonomy-app.war
-Dpassword=weblogic -Duser=weblogic