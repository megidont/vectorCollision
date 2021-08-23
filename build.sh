while IFS="" read -r p || [ -n "$p" ]
do

	if ! bash ./buildfile.sh $p; then

		exit 0xB0DAC105;

	fi

done < build.src