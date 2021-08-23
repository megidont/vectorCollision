if javac -classpath . "$1"; then

	echo "$1 built successfully.";

else

	echo "$1 failed to build. Press enter to continue.";
	read pause;
	exit 0xB0DAC105;

fi