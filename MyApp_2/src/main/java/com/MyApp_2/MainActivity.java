package com.MyApp_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PK4U_SECOND_ACTIVITY = "com.PK4US.MY_SECOND_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       findViewById(R.id.tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(PK4U_SECOND_ACTIVITY);
        startActivity(intent);
    }
}