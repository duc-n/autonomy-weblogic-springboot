#Spring Boot for Oracle Weblogic

Proof of concept project, how to deploy spring boot based web app into Oracle Weblogic application server. 

Important things to note :

1. Make sure the oracle-maven-sync-12.2.1 dependency is installed correctly. 
	1) Step to install the oracle-maven-sync-12.2.1 dependency
	
	-  Run the command from : C:\Dev\Oracle\Weblogic12.2.1.3.0\oracle_common\plugins\maven\com\oracle\maven\oracle-maven-sync\12.2.1>mvn install:install-file -DpomFile=oracle-maven-sync-12.2.1.pom -Dfile=oracle-maven-sync-12.2.1.jar
	- mvn com.oracle.maven:oracle-maven-sync:push -DoracleHome=C:\Dev\Oracle\Weblogic12.2.1.3.0\