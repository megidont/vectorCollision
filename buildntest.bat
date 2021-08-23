@echo off
CALL build.bat
java -classpath . %~n1
