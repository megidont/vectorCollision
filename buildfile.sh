#!/usr/bin/bash

if javac -classpath . "$1"; then

	echo "$1 built successfully.";

else

	echo "$1 failed to build. Press enter to continue.";
	read pause;
	exit $((16#B0DAC105));

fi