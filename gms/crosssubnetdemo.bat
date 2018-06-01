@echo off

REM
REM  # Copyright (c) 2010, 2018 Oracle and/or its affiliates. All rights reserved.
REM
REM This program and the accompanying materials are made available under the
REM terms of the Eclipse Public License v. 2.0, which is available at
REM http://www.eclipse.org/legal/epl-2.0.

REM This Source Code may also be made available under the following Secondary
REM Licenses when the conditions for such availability set forth in the
REM Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
REM version 2 with the GNU Classpath Exception, which is available at
REM https://www.gnu.org/software/classpath/license.html.

REM SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
REM

setlocal
set publish_home=.\dist
set lib_home=.\lib
set jdk_home=%JAVA_HOME%\bin
echo %jdk_home%


if "%1a"=="a" goto usage
if "%2a"=="a" goto usage
if "%3a"=="a" goto usage
if "%4a"=="a" goto usage
if "%5a"=="a" goto usage
if "%6a"=="a" goto usage
if "%7a"=="a" goto usage

echo "%jdk_home%"\java -Dcom.sun.management.jmxremote -DMEMBERTYPE=%3 -DINSTANCEID=%1 -DCLUSTERNAME=%2 -DMESSAGING_MODE=true -DLIFEINMILLIS=%4 -DLOG_LEVEL=%5 -D%6=%7 -D%8=%9 -cp %publish_home%/shoal-gms-tests.jar;%publish_home%/shoal-gms.jar;%lib_home%/jxta.jar com.sun.enterprise.ee.cms.tests.ApplicationServer
"%jdk_home%"\java -Dcom.sun.management.jmxremote -DMEMBERTYPE=%3 -DINSTANCEID=%1 -DCLUSTERNAME=%2 -DMESSAGING_MODE=true -DLIFEINMILLIS=%4 -DLOG_LEVEL=%5 -D%6=%7 -D%8=%9 -cp %publish_home%/shoal-gms-tests.jar;%publish_home%/shoal-gms.jar;%lib_home%/jxta.jar com.sun.enterprise.ee.cms.tests.ApplicationServer

goto end

:usage
echo Usage: %0 parameters... 
echo The required parameters are :
echo instance_id_token groupname membertype{CORE--OR--SPECTATOR} Life-In-Milliseconds log-level IS_INITIAL_HOST={true--OR--false} INITIAL_HOST_LIST={comma separated (no space) list of tcp addresses in the form tcp://ipaddress:port}
echo Life in milliseconds should be at least 60000 to demo failure fencing.

:end
endlocal
