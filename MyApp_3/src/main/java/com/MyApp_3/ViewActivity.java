package com.MyApp_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private ArrayList<String> ArrComp;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ArrComp = new ArrayList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,ArrComp);

        Bundle args = getIntent().getExtras();
        if (args!=null){
            Computer computer = (Computer) args.getSerializable(Computer.class.getSimpleName());
            ListView lv_comp = findViewById(R.id.lv_comp);
            lv_comp.setAdapter(adapter);

            ArrComp.add(computer.toString());
            adapter.notifyDataSetChanged();
        }
    }

    public void onClickButtonBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}