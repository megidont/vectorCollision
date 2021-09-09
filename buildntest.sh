#!/usr/bin/bash
if bash ./build.sh; then

	if bash ./builddocs.sh; then

		java -classpath . $(basename $1 .java);

	else

		echo "Documentation building failed! Continue? (Y/n)"
		read -n 1 answer
		if [[ ${answer,,} != "n" ]]; then

			java -classpath . $(basename $1 .java);

		else

			echo "Build succeeded, documentation building failed."
			exit $((16#BAD0D0C5))

		fi

	fi

else

	echo "Build failed! Press enter to finish.";
	read pause;
	exit $((16#B0DAC105));

fi
