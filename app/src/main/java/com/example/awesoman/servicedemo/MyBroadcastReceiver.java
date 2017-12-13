package com.example.awesoman.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Awesome on 2017/12/13.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("cen","onReceive -- 启动ServiceDemo 中的 MyService");
        long a = intent.getLongExtra("a",-1);
        long b = intent.getLongExtra("b",-1);

        Intent intentService = new Intent(context,MyService.class);
        intentService.putExtra("a",a);
        intentService.putExtra("b",b);
        context.startService(intentService);
    }
}
