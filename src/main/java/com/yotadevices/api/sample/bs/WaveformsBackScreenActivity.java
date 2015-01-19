package com.yotadevices.api.sample.bs;

import com.yotadevices.sdk.BSActivity;
import com.yotadevices.sdk.BSDrawer.Waveform;

import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

public class WaveformsBackScreenActivity extends BSActivity {

    public static final String EXTRA_WAVEFORM = "waveform";
    public static final String EXTRA_TEXT = "text";

    private TextView mTextView;

    @Override
    protected void onBSCreate() {
        super.onBSCreate();

        mTextView = new TextView(getContext());
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setBackgroundColor(Color.WHITE);
        mTextView.setTextColor(Color.BLACK);
        mTextView.setTextSize(25);
        mTextView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);

        Waveform wave = Waveform.WAVEFORM_GC_PARTIAL;
        if (intent.hasExtra(EXTRA_WAVEFORM)) {
            wave = (Waveform) intent.getSerializableExtra(EXTRA_WAVEFORM);
        }

        String text = "Hello, world!";
        if (intent.hasExtra(EXTRA_TEXT)) {
            text = intent.getStringExtra(EXTRA_TEXT);
        }

        mTextView.setText(text);
        getBSDrawer().drawBitmap(mTextView, wave);
    }
}
