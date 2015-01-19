
package com.yotadevices.api.sample.bs;


public class FullScreenBackScreenActivity extends MyBackScreenActivity {

    @Override
    protected void onBSCreate() {
        super.onBSCreate();
        setFullScreenMode(true);
    }

}
