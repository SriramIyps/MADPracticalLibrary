package com.example.myapplication5;

import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity {

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button start=findViewById(R.id.btnStart);
        Button stop=findViewById(R.id.btnStop);

        start.setOnClickListener(v ->
                Toast.makeText(this,"Process Started",Toast.LENGTH_SHORT).show());

        stop.setOnClickListener(v ->
                Toast.makeText(this,"Process Stopped",Toast.LENGTH_SHORT).show());
    }
}