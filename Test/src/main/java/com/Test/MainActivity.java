package com.Test;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> beverages;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beverages = new ArrayList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,beverages);
        ListView lv = findViewById(R.id.LV);
        lv.setAdapter(adapter);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                adapter.remove(adapter.getItem(position));
//                adapter.notifyDataSetChanged();
//            }
//        });
    }

    public void onClickButtonAdd(View view) {
        EditText et = findViewById(R.id.et);
        EditText et2 = findViewById(R.id.et2);
        Computer computer = new Computer(et.getText().toString(), Integer.parseInt(et2.getText().toString()));
//        if (et.getText().toString().equals("") || et2.getText().toString().equals("")) {
//            CallToast();
//        }else {
            beverages.add(computer.toString());
            adapter.notifyDataSetChanged();
//        }
    }

//    private void CallToast() {
//        Toast toast  = Toast.makeText(this, "Вы ничего не ввели!",Toast.LENGTH_SHORT);
//        toast.show();
//    }

}
