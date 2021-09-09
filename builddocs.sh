#!/usr/bin/bash
if [ -d docs ]; then

	echo "Docs dir present, using existing...";

else

	echo "Docs dir not present, creating...";
	mkdir "docs";

fi

cd docs;

if !(javadoc us.megidont.avc --class-path=../); then
	exit $((16#BAD0D0C5));
fi