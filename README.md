#Spring Boot for Oracle Weblogic

Proof of concept project, how to deploy spring boot based web app into Oracle Weblogic application server. 

Important things to note :

1. Make sure the oracle-maven-sync-12.2.1 dependency is installed correctly. 
	1) Step to install the oracle-maven-sync-12.2.1 dependency
	
	-  Run the command from : C:\Dev\Oracle\Weblogic12.2.1.3.0\oracle_common\plugins\maven\com\oracle\maven\oracle-maven-sync\12.2.1>mvn install:install-file -DpomFile=oracle-maven-sync-12.2.1.pom -Dfile=oracle-maven-sync-12.2.1.jar
	- mvn com.oracle.maven:oracle-maven-sync:push -DoracleHome=C:\Dev\Oracle\Weblogic12.2.1.3.0\
	
2. When deploying the application to weblogic from Eclipse, if there is an error Web 4 not supported:
Modify the file org.eclipse.wst.common.project.facet.core.xml in the .settings directory :
<installed facet="jst.web" version="3.0"/>

un fichier org.eclipse.wst.common.project.facet.core.xml

3. Add log4j2 configuration in the cofaceSetenv.cmd :
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dlog4j2.configurationFile=file:%CONFIG_PATH%\log4j2.xml

4.Url : http://grprocxd10-078.group.coface.dns:7001/autonomy/ping