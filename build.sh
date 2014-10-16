#!/bin/bash
if [[ $# -eq 0 ]]
    then
        mvn clean package
else
    mvn $@
fi