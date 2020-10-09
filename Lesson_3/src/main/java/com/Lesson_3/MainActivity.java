package com.Lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText name = findViewById(R.id.et_name);
        EditText age = findViewById(R.id.et_age);
        Person person = new Person(name.getText().toString(), Integer.parseInt(age.getText().toString()));

        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("Example","Hello");
        intent.putExtra(Person.class.getSimpleName(),person);
        startActivity(intent);
    }
}