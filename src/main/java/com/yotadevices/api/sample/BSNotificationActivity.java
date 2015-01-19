package com.yotadevices.api.sample;

import com.yotadevices.sdk.notifications.BSNotification;
import com.yotadevices.sdk.notifications.BSNotificationManager;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;

public class BSNotificationActivity extends Activity {

    /**
     * Helper enum
     * 
     */
    enum Notification {
        NOTIFICATION_BAR, NOTIFICATION_HALF, NOTIFICATION_FULL;

        public int getNotificationId() {
            switch (this) {
            case NOTIFICATION_BAR:
                return 1;
            case NOTIFICATION_HALF:
                return 2;
            case NOTIFICATION_FULL:
                return 3;
            default:
                return 1;
            }
        }

        static public Notification valueOfType(int type) {
            switch (type) {
            case BSNotification.BAR_NOTIFICATION:
                return NOTIFICATION_BAR;
            case BSNotification.HALF_SCREEN_NOTIFICATION:
                return NOTIFICATION_HALF;
            case BSNotification.FULL_SCREEN_NOTIFICATION:
                return NOTIFICATION_FULL;
            default:
                return NOTIFICATION_BAR;
            }
        }
    }

    private EditText mTitleNotification;
    private EditText mDescriptionNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs_notification);

        init();
    }

    private void init() {
        mTitleNotification = (EditText) findViewById(R.id.edit_text_title);
        mDescriptionNotification = (EditText) findViewById(R.id.edit_text_description);

        findViewById(R.id.btn_send_notification).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    private int getCurrentNotificationType() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
        switch (group.getCheckedRadioButtonId()) {
        case R.id.notification_full:
            return BSNotification.FULL_SCREEN_NOTIFICATION;
        case R.id.notification_half:
            return BSNotification.HALF_SCREEN_NOTIFICATION;
        case R.id.notification_bar:
            return BSNotification.BAR_NOTIFICATION;
        default:
            break;
        }

        return BSNotification.BAR_NOTIFICATION;
    }

    private void sendNotification() {
        int type = getCurrentNotificationType();
        Notification n = Notification.valueOfType(type);

        BSNotification.Builder builder = new BSNotification.Builder();
        builder.setContentTitle(mTitleNotification.getText().toString());
        builder.setContentText(mDescriptionNotification.getText().toString());
        builder.setNotificationType(type);

        // icon for bar notification
        builder.setSmallIcon(R.drawable.ic_launcher);

        switch (type) {
        case BSNotification.FULL_SCREEN_NOTIFICATION:
            builder.setFullScreenBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.fs_dolp));
            break;
        case BSNotification.HALF_SCREEN_NOTIFICATION:
            builder.setHalfScreenBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.test_sarah));
            break;
        default:
            break;
        }

        BSNotificationManager manager = new BSNotificationManager(getApplicationContext());
        manager.notify(n.getNotificationId(), builder.build());
    }

}
