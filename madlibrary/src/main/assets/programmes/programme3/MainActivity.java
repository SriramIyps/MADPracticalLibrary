package com.example.myapplication3;

import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity {

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("Alert")
                        .setMessage("Welcome to AlertDialog")
                        .setPositiveButton("OK", null)
                        .show()
        );
    }
}