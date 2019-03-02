package com.example.timepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class SetActivity extends AppCompatActivity {
    EditText note;
    TimePicker timePicker;
    Button button;

    public static final String EXTRA_REPLY ="com.example.android.timepicker.extra.REPLY";
    public static final String EXTRA_REPLY_2 ="com.example.android.timepicker.extra.REPLY_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        note = findViewById(R.id.note);
        timePicker = findViewById(R.id.pick);
        button = findViewById(R.id.set_time);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notes = note.getText().toString();
                String time = timePicker.getCurrentHour().toString() +":" + timePicker.getCurrentMinute().toString();

                Intent intent = new Intent();
                intent.putExtra(EXTRA_REPLY, time);
                intent.putExtra(EXTRA_REPLY_2, notes);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
