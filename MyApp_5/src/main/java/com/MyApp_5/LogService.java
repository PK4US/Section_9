package com.MyApp_5;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void SendNotif(){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String CHANNEL_ID = "my_channel";
        int NOTIFICATION_ID = 1;
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Мои уведомления", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Описание канала");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Заголовок уведомления")
                .setContentText("Текст уведомления")
                .setVibrate(new long[]{0,2000,1100,1000})
                .setSmallIcon(R.mipmap.ic_launcher);
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,0,intent,0);

        notificationManager.notify(NOTIFICATION_ID,builder.build());
    }

    public void onCreate(){
        super.onCreate();
        log("Старт сервиса");
        new Thread(new Runnable() {
            Date d;
            SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");
            @Override
            public void run() {
                int i = 0;
                while (true){
                    d = new Date();
                    log("Текущее время: " + format1.format(d));
                    SendNotif();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } i++;
                }
            }
        }).start();
    }

    private void log (String msg){
        System.out.println(msg);
    }
}