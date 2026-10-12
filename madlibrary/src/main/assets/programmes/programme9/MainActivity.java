package com.example.myapplication9;



import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity {
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText n1=findViewById(R.id.num1);
        EditText n2=findViewById(R.id.num2);
        TextView r=findViewById(R.id.result);

        findViewById(R.id.add).setOnClickListener(v ->
                r.setText(""+(Double.parseDouble(n1.getText().toString())+
                        Double.parseDouble(n2.getText().toString()))));

        findViewById(R.id.sub).setOnClickListener(v ->
                r.setText(""+(Double.parseDouble(n1.getText().toString())-
                        Double.parseDouble(n2.getText().toString()))));

        findViewById(R.id.mul).setOnClickListener(v ->
                r.setText(""+(Double.parseDouble(n1.getText().toString())*
                        Double.parseDouble(n2.getText().toString()))));

        findViewById(R.id.div).setOnClickListener(v ->
                r.setText(""+(Double.parseDouble(n1.getText().toString())/
                        Double.parseDouble(n2.getText().toString()))));
    }
}