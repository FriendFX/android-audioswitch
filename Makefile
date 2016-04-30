PACKAGE_NAME = io.github.friendfx.android_audioswitch
ACTIVITY_NAME = MainActivity

.PHONY: android_build android_run

android_build:
	gradle build -info

android_run:
	gradle installDebug -info
	adb shell am start -n ${PACKAGE_NAME}/${PACKAGE_NAME}.${ACTIVITY_NAME}
	adb logcat

