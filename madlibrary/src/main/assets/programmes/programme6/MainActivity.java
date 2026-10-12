package com.example.myapplication6;



import android.app.*;
import android.os.*;
import android.content.*;
import android.net.*;
import android.widget.*;

public class MainActivity extends Activity {
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button a=findViewById(R.id.Activity);
        Button w=findViewById(R.id.Website);

        a.setOnClickListener(v -> {
            startActivity(new Intent(this,new6.class));
        });

        w.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")));
        });
    }
}