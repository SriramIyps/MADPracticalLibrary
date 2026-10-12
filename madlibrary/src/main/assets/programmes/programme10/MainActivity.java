package com.example.myapplication10;



import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.Random;

public class MainActivity extends Activity {
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        EditText g=findViewById(R.id.guess);
        TextView r=findViewById(R.id.result);

        findViewById(R.id.check).setOnClickListener(v -> {
            int n=new Random().nextInt(10)+1;
            int u=Integer.parseInt(g.getText().toString());

            if(u==n)
                r.setText("You Win!");
            else
                r.setText("You Lose! Number = "+n);
        });
    }
}