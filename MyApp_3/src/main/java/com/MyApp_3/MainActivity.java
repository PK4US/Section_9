package com.MyApp_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButtonAdd(View view) {
        EditText title = findViewById(R.id.et_title);
        EditText price = findViewById(R.id.et_price);
        Computer computer = new Computer(title.getText().toString(), Integer.parseInt(price.getText().toString()));

        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra(Computer.class.getSimpleName(),computer);
        startActivity(intent);
    }
}