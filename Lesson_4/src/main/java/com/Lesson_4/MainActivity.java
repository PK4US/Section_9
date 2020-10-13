package com.Lesson_4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_start = findViewById(R.id.button_start);
        Button button_stop = findViewById(R.id.button_stop);
        button_start.setOnClickListener(this);
        button_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent service = new Intent(this, LogService.class);
        switch (view.getId()){
            case R.id.button_start:{
                startService(service);
                break;
            }
            case R.id.button_stop:{
                stopService(service);
                break;
            }
        }
    }
}
