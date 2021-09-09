#!/usr/bin/bash

#echo "This will delete the current jars directory and any directory named temp. Press enter when ready.";
#read justincase;
rm -rf jars;

basedir=$(pwd);

mkdir jars/;
mkdir -p temp/us/megidont/avc/;

cd temp;
echo "Name: us/megidont/avc/" > manifest.txt;
echo "Sealed: true" >> manifest.txt;

cp ${basedir}/us/megidont/avc/*.class us/megidont/avc/;
jar -c0fm ${basedir}/jars/avc.jar manifest.txt us;
echo "Created release jar."
rm us/megidont/avc/*

cp ${basedir}/us/megidont/avc/*.java us/megidont/avc/;
jar -c0f ${basedir}/jars/avc-src.jar us;
echo "Created sources jar."
rm us/megidont/avc/*

cd ${basedir}/docs/;
jar -c0f ${basedir}/jars/avc-docs.jar .;
echo "Created docs jar."

cd ..;
rm -rf temp;