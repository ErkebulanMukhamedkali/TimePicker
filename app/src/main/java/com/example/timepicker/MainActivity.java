package com.example.timepicker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button add;
    ListView listView;
    Dialog dialog;
    AlertDialog.Builder builder;

    ArrayList<MyClass> times;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        add = findViewById(R.id.add);
        times = new ArrayList<MyClass>();
        fill();
        adapter = new MyAdapter(this, times);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        listView.setAdapter(adapter);
        dialog = new Dialog(MainActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String time = data.getStringExtra(SetActivity.EXTRA_REPLY);
                String note = data.getStringExtra(SetActivity.EXTRA_REPLY_2);

                MyClass clock = new MyClass(time, note);
                times.add(clock);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new MyAdapter(this, times);
        listView.setAdapter(adapter);
    }

    public void fill() {
        times.add(new MyClass("08:00", "Good Morning"));
        times.add(new MyClass("13:00", "Launch Time"));
        times.add(new MyClass("22:00", "Sleeping Time"));
        times.add(new MyClass("00:00", ""));

    }


    public void dialogYo(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog);
                TextView time = v.findViewById(R.id.time);
                dialog.setTitle(time.getText().toString().split(":")[0] + " hours left");
                dialog.setCancelable(true);
                Button ok = dialog.findViewById(R.id.ok_button);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }
}
