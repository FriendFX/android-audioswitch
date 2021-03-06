/*
This file is part of Android Audioswitch.

Android Audioswitch is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Android Audioswitch is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Android Audioswitch.  If not, see <http://www.gnu.org/licenses/>.
*/
package io.github.friendfx.android_audioswitch;

import android.util.Log;
// http://oneyoung.im/2014/12/26/force-route-audio-stream-to-headphone/

class AudioSystem {
	private static final String TAG = "AudioSystem";
	private static final int REFLECTION_ERROR = -999;
	
	//protected static final Class<?> mAudioSystem = Class.forName("android.media.AudioSystem");
	protected static Class<?> mAudioSystem() {
		try {
			return Class.forName("android.media.AudioSystem");
		} catch (Exception e) {
			Log.e(TAG, "mAudioSystem failed: " + e);
		}
		return null;
	}
	
	protected static Object getAudioSystemField(String name, Object obj) {
		try {
			return mAudioSystem().getDeclaredField(name).get(obj);
		} catch (Exception e) {
			Log.e(TAG, "getAudioSystemField failed: " + e);
		}
		return null;
	}
	
	public static final int DEVICE_OUT_WIRED_HEADSET = ((Integer)getAudioSystemField("DEVICE_OUT_WIRED_HEADSET", int.class)).intValue();
	public static final String DEVICE_OUT_WIRED_HEADSET_NAME = ((String)getAudioSystemField("DEVICE_OUT_WIRED_HEADSET_NAME", String.class));
	
	public static int setDeviceConnectionState(int device, int state, String device_address) {
		try {
			Log.i(TAG, "setDeviceConnectionState(device="+String.valueOf(device)+", state="+String.valueOf(state)+", address='"+device_address+"')");
			return (Integer) mAudioSystem().getMethod("setDeviceConnectionState", int.class, int.class, String.class).invoke(mAudioSystem(), device, state, device_address);
		} catch (Exception e) {
			Log.e(TAG, "setDeviceConnectionState failed: " + e);
		}
		return REFLECTION_ERROR;
	}

	public static int getDeviceConnectionState(int device, String device_address) {
		try {
			Log.i(TAG, "getDeviceConnectionState(device="+String.valueOf(device)+", address='"+device_address+"')...");
			int result = (Integer) mAudioSystem().getMethod("getDeviceConnectionState", int.class, String.class).invoke(mAudioSystem(), device, device_address);
			Log.i(TAG, "getDeviceConnectionState(device="+String.valueOf(device)+", address='"+device_address+"') = "+String.valueOf(result));
            return result;
		} catch (Exception e) {
			Log.e(TAG, "getDeviceConnectionState failed: " + e);
		}
		return REFLECTION_ERROR;
    }
    

}
