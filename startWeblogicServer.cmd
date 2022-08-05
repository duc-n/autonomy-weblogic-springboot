@echo off
call C:\Dev\workspaceXide5.5.0\wlsDomain12_GRPROCXD10-078\cofaceSetenv.cmd %*
mvn com.oracle.weblogic:weblogic-maven-plugin:start-server -DdomainHome=C:\Dev\workspaceXide5.5.0\wlsDomain12_GRPROCXD10-078