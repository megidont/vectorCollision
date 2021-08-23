@echo off
javac -classpath . "%~1"
IF NOT ERRORLEVEL == 0 (

	ECHO %1 failed to build. Press enter to continue.
	PAUSE
	EXIT 0xB0DAC105

) ELSE (

	ECHO %1 built successfully.

)
