PACKAGE_NAME = io.github.friendfx.android_audioswitch
ACTIVITY_NAME = MainActivity

android_run:
	gradle installDebug -info
	adb shell am start -n ${PACKAGE_NAME}/${PACKAGE_NAME}.${ACTIVITY_NAME}
	adb logcat

