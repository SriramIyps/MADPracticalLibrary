package com.example.myapplication1;



import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {


    int count = 0;

    @Override
    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> {

            if (count == 0)
                textView.setTextColor(Color.RED);
            else if (count == 1)
                textView.setTextColor(Color.BLUE);
            else if (count == 2)
                textView.setTextColor(Color.GREEN);
            else
                textView.setTextColor(Color.MAGENTA);
            count = (count + 1) % 4;
        });
    }
}