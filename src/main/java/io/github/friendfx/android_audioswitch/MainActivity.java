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

import android.app.Activity;
import android.widget.CheckBox;
import android.view.View;
import android.util.Log;
public class MainActivity extends Activity {
	protected CheckBox wiredHeadsetCheckbox;
	private static final String TAG = "MainActivity";
    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        wiredHeadsetCheckbox = (CheckBox) findViewById(R.id.wiredHeadsetCheckbox);
    }
	
	protected boolean isDeviceEnabled(int device) {
		return AudioSystem.getDeviceConnectionState(device, "") != 0 ? true : false;
	}
	
	protected void setDeviceEnabled(int device, boolean enable) {
		AudioSystem.setDeviceConnectionState(device, enable ? 1 : 0, "");
	}
	
    @Override
    public void onStart() {
        super.onStart();
        wiredHeadsetCheckbox.setChecked(isDeviceEnabled(AudioSystem.DEVICE_OUT_WIRED_HEADSET));
    }
    
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.wiredHeadsetCheckbox:
				setDeviceEnabled(AudioSystem.DEVICE_OUT_WIRED_HEADSET, checked);
                break;
        }
    }
}
