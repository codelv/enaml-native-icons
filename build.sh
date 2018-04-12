#!/usr/bin/env bash

export TARGETS=("iphoneos iphonesimulator android/arm android/arm64 android/x86 android/x86_64")
for TARGET in $TARGETS
do
    mkdir -p $PREFIX/$TARGET/python/site-packages/
    cp -RL $RECIPE_DIR/src/iconify $PREFIX/$TARGET/python/site-packages/
done

# Install android lib
mkdir -p $PREFIX/android/
cp -RL $RECIPE_DIR/android $PREFIX/android/$PKG_NAME
