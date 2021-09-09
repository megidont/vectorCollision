if bash ./build.sh; then

	java -classpath . $(basename $1 .java);

else

	echo "Build failed! Press enter to finish.";
	read pause;
	exit $((16#B0DAC105));

fi
