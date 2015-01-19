
package com.yotadevices.api.sample;

import com.yotadevices.api.sample.bs.FullScreenBackScreenActivity;
import com.yotadevices.api.sample.bs.MyBackScreenActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;

public class SimpleBSActivity extends Activity {

    private EditText mTextMessage;
    private CheckBox mFullScreenMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs_activity);

        mTextMessage = (EditText)findViewById(R.id.edit_text_message);
        mFullScreenMode = (CheckBox)findViewById(R.id.fullscreen);
        findViewById(R.id.btn_send_message).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toBackScreen();
            }
        });
    }

    private void toBackScreen() {
        Intent i = new Intent(this,
                mFullScreenMode.isChecked() ? FullScreenBackScreenActivity.class
                        : MyBackScreenActivity.class);
        i.putExtra(MyBackScreenActivity.ACTION_NUMBER,
                Integer.valueOf(mTextMessage.getText().toString()));
        startService(i);
    }
}
