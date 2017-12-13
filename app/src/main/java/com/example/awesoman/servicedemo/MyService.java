package com.example.awesoman.servicedemo;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Awesome on 2017/12/13.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("cen","MyService - onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        long a = intent.getLongExtra("a",-1);
        long b = intent.getLongExtra("b",-1);
        Log.i("cen","onBind a:"+a+" b"+b);
        response(plus(a,b));
    }

    public long plus(long a, long b){
        return a+b;
    }

    public void response(long response){
        Intent intent = new Intent("android.intent.action.ResponseBroadcastReceiver");
        intent.putExtra("response",response);
        sendBroadcast(intent);
    }

}
