package com.yotadevices.api.sample.bs;

import com.yotadevices.sdk.BSActivity;
import com.yotadevices.sdk.BSDrawer.Waveform;
import com.yotadevices.sdk.BSMotionEvent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MyBackScreenActivity extends BSActivity {

    public final static String ACTION_NUMBER = "action_number";
    public final static String ISACTION_NUMBER = "action_number";
    public final static int DEFAULT_COUNTER = 100;

    private int counter;
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
    protected void onBSResume() {
        super.onBSResume();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        if (intent.hasExtra(ACTION_NUMBER)) {
            counter = intent.getIntExtra(ACTION_NUMBER, DEFAULT_COUNTER);
        }

        drawNumber();
    }

    // add the text "Hello, world" to user number
    private void drawNumber() {
        mTextView.setText("Hello, world!\n(" + counter + ")");
        getBSDrawer().drawBitmap(mTextView, Waveform.WAVEFORM_GC_PARTIAL);
    }

    @Override
    protected void onBSTouchEvent(BSMotionEvent motionEvent) {
        super.onBSTouchEvent(motionEvent);
        switch (motionEvent.getBSAction()) {
        case GESTURES_BS_LR:
            counter--;
            drawNumber();
            break;
        case GESTURES_BS_RL:
            counter++;
            drawNumber();
            break;
        default:
            break;
        }
    }

    @Override
    protected void onBSSaveInstanceState(Bundle outState) {
        super.onBSSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    @Override
    protected void onBSRestoreInstanceState(Bundle savedInstanceState) {
        super.onBSRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter", DEFAULT_COUNTER);
    }

}
