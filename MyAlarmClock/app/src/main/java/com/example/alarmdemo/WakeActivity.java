package com.example.alarmdemo;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WakeActivity extends AppCompatActivity {
    Ringtone ringtone;
    TextView tv_clock_wake;
    ImageView iv_off_wake;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake);
        overridePendingTransition(R.anim.bot_in, R.anim.top_out);
        String strTime = getIntent().getStringExtra("time");
        tv_clock_wake = findViewById(R.id.tv_clock_wake);
        tv_clock_wake.setText(strTime);
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null)
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        ringtone = RingtoneManager.getRingtone(this, alarmUri);
        ringtone.play();
        iv_off_wake = findViewById(R.id.iv_off_wake);
        iv_off_wake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.top_in, R.anim.bot_out);
            }
        });
    }

    @Override
    protected void onStop() {
        ringtone.stop();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.top_in, R.anim.bot_out);
    }
}