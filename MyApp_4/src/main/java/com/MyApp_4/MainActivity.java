package com.MyApp_4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonUpdate = findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener(this);

        Intent service = new Intent(this, LogService.class);
        startService(service);
    }


    // не работает. При нажатии выводит нулл
    @Override
    public void onClick(View view) {
        TextView textViewTime = findViewById(R.id.tv_time);
        LogService logService = new LogService();

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String date = sdf.format(Calendar.getInstance().getTime());
        textViewTime.setText(date);
    }
}

