# Android Audioswitch

A minimalistic app to disable the wired headset audio output even when the headset is plugged in.


## Motivation

Using the wired headset too much with my phone has resulted in a faulty headphone jack which detects the headset being connected without it really being plugged-in - [here is the detailed problem description on Android Enthusiasts](https://android.stackexchange.com/questions/124491/phone-call-audio-works-only-with-speakerphone-or-wired-headset).

Although quite a few people appear to have this problem, there seem to be only a few apps around that promise to solve this issue which were either

 * not open source,
 * were written for an older Android version,
 * didn't work on my phone for other reasons or
 * were too cumbersome/unreliable to use when in the process of receiving a call.

In addition, I recently got a bit involved with mobile app development and finally had the time to solve this problem for myself and hopefully others.

## Build Instructions

### Prerequisites

 * [Android SDK](https://developer.android.com/sdk/index.html) (no need to get the whole Android Studio by the way).
 * [Gradle](http://gradle.org/) for which I found a nice [tutorial](https://spring.io/guides/gs/gradle-android/).

### Getting the Code

 * If you happen to have Git installed, it should be as simple as `git clone https://github.com/FriendFX/android-audioswitch.git`
 * Without Git, you can download the source in ZIP format from https://github.com/FriendFX/android-audioswitch/archive/master.zip

### Building/Installing/Running

The included Makefile lets you `make android_run` which builds and install it on the device as well as starting the app. If you don't have a device or just want to build, use `make build`.


## Credits

The idea to use the (hidden but still existent) [`android.media.AudioSystem`](https://github.com/android/platform_frameworks_base/blob/master/media/java/android/media/AudioSystem.java) class I got from the following website:

http://oneyoung.im/2014/12/26/force-route-audio-stream-to-headphone/

Which in turn I found through an [answer on StackOverflow](http://stackoverflow.com/a/30049718/897968).

