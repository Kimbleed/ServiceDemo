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

        /*
            3.广播启动了Service
            一启动调用Service中的方法 plus
            并且发送广播，返回结果给SendDemo
            PS:每一次MyBroadcastReceiver中  调用startService()，我不确定 是否每次都走onStart，但肯定每次都走 onStartCommand，你自己试试吧，不知我说的方法在哪就搜索下当前类
         */
        long a = intent.getLongExtra("a",-1);
        long b = intent.getLongExtra("b",-1);
        Log.i("cen","onBind a:"+a+" b"+b);
        response(plus(a,b));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /*

         */
        return super.onStartCommand(intent, flags, startId);
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
