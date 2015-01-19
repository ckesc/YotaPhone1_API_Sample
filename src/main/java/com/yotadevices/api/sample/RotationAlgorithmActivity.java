package com.yotadevices.api.sample;

import com.yotadevices.api.sample.bs.DitherBackScreenActivity;
import com.yotadevices.sdk.utils.EinkUtils;
import com.yotadevices.sdk.utils.RotationAlgorithm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class RotationAlgorithmActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        findViewById(R.id.btn_p2b).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPicture();
            }
        });
    }

    private void drawPicture() {
        RotationAlgorithm.getInstance(getApplicationContext()).issueStandardToastAndVibration();
        RotationAlgorithm.getInstance(getApplicationContext()).turnScreenOffIfRotated();

        Intent i = new Intent(this, DitherBackScreenActivity.class);
        i.putExtra("dither", EinkUtils.ATKINSON_DITHERING);
        i.putExtra("preapre", false);
        startService(i);
    }

}
