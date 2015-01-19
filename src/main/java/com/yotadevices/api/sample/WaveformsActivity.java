package com.yotadevices.api.sample;

import com.yotadevices.api.sample.bs.WaveformsBackScreenActivity;
import com.yotadevices.sdk.BSDrawer.Waveform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.Locale;

public class WaveformsActivity extends Activity {

    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waveform);
        mEdit = (EditText) findViewById(R.id.edit_text_message);

        findViewById(R.id.btn_draw_message).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawMessage();
            }
        });

        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
        group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String text = ((RadioButton) findViewById(checkedId)).getText().toString();
                mEdit.setText(text.toLowerCase(Locale.ENGLISH));
            }
        });

    }

    private void drawMessage() {
        Intent i = new Intent(this, WaveformsBackScreenActivity.class);
        i.putExtra(WaveformsBackScreenActivity.EXTRA_TEXT, mEdit.getText().toString());
        i.putExtra(WaveformsBackScreenActivity.EXTRA_WAVEFORM, getCurrentWaveForm());
        startService(i);
    }

    private Waveform getCurrentWaveForm() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
        switch (group.getCheckedRadioButtonId()) {
        case R.id.wave_full:
            return Waveform.WAVEFORM_GC_FULL;
        case R.id.wave_partial:
            return Waveform.WAVEFORM_GC_PARTIAL;
        case R.id.wave_du:
            return Waveform.WAVEFORM_DU;
        case R.id.wave_a2:
            return Waveform.WAVEFORM_A2;
        default:
            break;
        }

        return Waveform.WAVEFORM_GC_PARTIAL;
    }

}
