package com.codegama.todolistapplication.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.codegama.todolistapplication.activity.AlarmActivity;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    String title, desc, date, time;

    @Override
    public void onReceive(Context context, Intent intent) {

        title = intent.getStringExtra("НАЗВ");
        desc = intent.getStringExtra("ОПИС");
        date = intent.getStringExtra("ДАТА");
        time = intent.getStringExtra("ВРЕМЯ");

        Intent i = new Intent(context, AlarmActivity.class);
        i.putExtra("НАЗВ", title);
        i.putExtra("ОПИС", desc);
        i.putExtra("ДАТА", date);
        i.putExtra("ВРЕМЯ", time);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
