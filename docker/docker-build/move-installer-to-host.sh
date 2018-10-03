#!/usr/bin/env bash
cd /home/equella/repo/Equella/Installer/target/
numOfZips=$(find . -maxdepth 1 -name '*.zip' | wc -l)
if [ $numOfZips -gt 0 ]
then
    newdir = /artifacts/installer-build-$(date)
    mv *.zip /artifacts/$newdir
    echo Moved $numOfZips to $newDir
else
    echo No installer zips to move!
fi
