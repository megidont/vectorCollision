@echo off
CALL build.bat
java -classpath .;./vectorCollision/ %~n1
