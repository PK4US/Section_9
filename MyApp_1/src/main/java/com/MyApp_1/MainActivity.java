package com.MyApp_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        TextView tv2 = findViewById(R.id.tv2);
        int num = Integer.parseInt(tv2.getText().toString());
        num++;
        tv2.setText(String.valueOf(num));
    }
}
