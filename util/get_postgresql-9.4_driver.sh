#!/bin/bash

if [ -e postgresql-9.4.jar ]; then
  echo suppression ancien driver
  rm postgresql-9.4.jar
fi

curl -O  https://repo1.maven.org/maven2/org/postgresql/postgresql/9.4.1212.jre7/postgresql-9.4.1212.jre7.jar
mv postgresql-9.4.1212.jre7.jar postgresql-9.4.jar

