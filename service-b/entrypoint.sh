#!/bin/bash

unzip /usr/local/tomcat/webapps/demo.war -d /usr/local/tomcat/webapps/demo

# TODO symlink
# ln -sf /appconfigs/override.properties /usr/local/tomcat/webapps/demo/WEB-INF/classes/override.properties
cp -v /appconfigs/override.properties /usr/local/tomcat/webapps/demo/WEB-INF/classes/override.properties

exec catalina.sh run
