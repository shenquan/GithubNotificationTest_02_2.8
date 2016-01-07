package com.example.administrator.notificationtest_02_28;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    static final int NOTIFICATION_ID = 0X123;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取系统服务
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    //发送按钮事件处理方法
    public void send(View source) {
        //创建一个启动其它Activity的Intent
        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.drawable.notify)
                .setContentTitle("一条新通知")
                .setContentText("恭喜您，您加薪了，工资增加20%！")
//                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
//                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
//               .setVibrate(new long[]{0, 50, 100, 150})
               .setVibrate(new long[]{100, 1000})
                .setSound(Uri.parse("android.resource://com.example.administrator.notificationtest_02_28/"+R.raw.msg))
                .build();
        //发送通知
        nm.notify(NOTIFICATION_ID, notification);

    }

    public void del(View v) {
        //取消通知
        nm.cancel(NOTIFICATION_ID);
    }

}
