package com.example.myapplication4;



import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity {

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnProgress);

        btn.setOnClickListener(v -> {
            ProgressDialog pd = new ProgressDialog(this);
            pd.setTitle("Loading");
            pd.setMessage("Please Wait");
            pd.show();

            new Handler().postDelayed(() -> {
                pd.dismiss();
                Toast.makeText(this, "Task Completed!",
                        Toast.LENGTH_SHORT).show();
            }, 3000);
        });
    }
}