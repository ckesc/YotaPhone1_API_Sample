package com.yotadevices.api.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.btn_bs_activity).setOnClickListener(this);
        findViewById(R.id.btn_bs_notification).setOnClickListener(this);
        findViewById(R.id.btn_waveforms).setOnClickListener(this);
        findViewById(R.id.btn_rotation).setOnClickListener(this);
        findViewById(R.id.btn_dithering).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn_bs_activity:
            startYotaActivity(SimpleBSActivity.class);
            break;
        case R.id.btn_bs_notification:
            startYotaActivity(BSNotificationActivity.class);
            break;
        case R.id.btn_waveforms:
            startYotaActivity(WaveformsActivity.class);
            break;
        case R.id.btn_rotation:
            startYotaActivity(RotationAlgorithmActivity.class);
            break;
        case R.id.btn_dithering:
            startYotaActivity(DitheringActivity.class);
            break;
        default:
            break;
        }

    }

    private void startYotaActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }

}
