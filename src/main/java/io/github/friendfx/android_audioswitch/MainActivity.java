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
