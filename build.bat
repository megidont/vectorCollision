@echo off
FOR /F "usebackq delims=|" %%G IN (build.src) DO CALL buildfile.bat %%G