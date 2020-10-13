package com.MyApp_4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private boolean stop;
    public String DateNowStr;


    public void onCreate(){
        super.onCreate();
        log("Старт сервиса");
        stop = false;
        new Thread(new Runnable() {
            Date d;
            SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");
            String date = format1.format(Calendar.getInstance().getTime());
            @Override
            public void run() {
                int i = 0;
                while (true){
                    d = new Date();
                    DateNowStr = (format1.format(d));
                    log("Текущее время: " + DateNowStr);
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