package com.yotadevices.api.sample;

import com.yotadevices.api.sample.bs.DitherBackScreenActivity;
import com.yotadevices.sdk.utils.EinkUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

public class DitheringActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dithering);
        findViewById(R.id.btn_draw_picture).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                drawPicture();
            }
        });
    }

    private void drawPicture() {
        Intent i = new Intent(this, DitherBackScreenActivity.class);
        i.putExtra("dither", getCurrentDither());
        i.putExtra("preapre", needPrepare());
        startService(i);
    }

    private int getCurrentDither() {
        RadioGroup group = (RadioGroup) findViewById(R.id.dither_group);
        switch (group.getCheckedRadioButtonId()) {
        case R.id.no_dither:
            return EinkUtils.NO_DITHERING;
        case R.id.dither:
            return EinkUtils.ATKINSON_DITHERING;
        case R.id.dither_with_prepare:
            return EinkUtils.ATKINSON_DITHERING;
        default:
            break;
        }

        return EinkUtils.NO_DITHERING;
    }

    private boolean needPrepare() {
        RadioGroup group = (RadioGroup) findViewById(R.id.dither_group);
        return group.getCheckedRadioButtonId() == R.id.dither_with_prepare ? true : false;
    }

}
