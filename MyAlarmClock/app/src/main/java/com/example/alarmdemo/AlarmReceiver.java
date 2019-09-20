package com.example.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String strTime = intent.getStringExtra("time");
        Intent intent1 = new Intent(context, WakeActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("time", strTime);
        context.startActivity(intent1);

    }
}