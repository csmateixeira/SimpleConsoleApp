:start
IF "%~1"=="" GOTO cleanpackage

mvn %*

:cleanpackage
mvn clean package


