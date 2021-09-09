#!/usr/bin/bash
if !(bash ./build.sh); then
	echo "Build failed."
	printf "%x\n" $?
fi
if !(bash ./builddocs.sh); then

	echo "Documentation building failed."
	printf "%x\n" $?

fi
if !(bash ./buildjars.sh); then

	echo "Jar building failed."
	printf "%x\n" $?

fi
echo "Done! Press enter to continue...";
read nicelydone;
exit 0;