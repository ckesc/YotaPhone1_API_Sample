package com.yotadevices.api.sample.bs;

import com.yotadevices.api.sample.R;
import com.yotadevices.sdk.BSActivity;
import com.yotadevices.sdk.BSDrawer.Waveform;
import com.yotadevices.sdk.utils.BitmapUtils;
import com.yotadevices.sdk.utils.EinkUtils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class DitherBackScreenActivity extends BSActivity {

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);

        int ditherAlgorithm = intent.getIntExtra("dither", EinkUtils.NO_DITHERING);
        boolean prepare = intent.getBooleanExtra("preapre", false);

        Bitmap bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.flamingo);
        if (prepare) {
            bmp = BitmapUtils.prepareImageForBS(getContext(), bmp);
        }

        getBSDrawer().drawBitmap(0, 0, bmp, Waveform.WAVEFORM_GC_FULL, ditherAlgorithm);
        getBSDrawer().drawBitmap(0, 0, bmp, Waveform.WAVEFORM_GC_FULL, ditherAlgorithm);
    }
}
