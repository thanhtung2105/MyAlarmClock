package com.example.alarmdemo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.*;

public class AlarmTask {

    public static void setAlarm(Context context, AlarmManager alarmManager, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("time", formatTime(hour, minute));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                pendingIntent
        );
    }


    public static String formatTime(int hour,int minute)
    {
        String strHour = String.valueOf(hour);
        String strMinute = String.valueOf(minute);
        if (hour < 10) {
            strHour = "0" + strHour;
        }
        if (minute < 10) {
            strMinute = "0" + strMinute;
        }
        return "$strHour:$strMinute";
    }


}