package com.example.myapplication8;




import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_main, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem i) {
        int id = i.getItemId();

        if (id == R.id.home)
            Toast.makeText(this, "Home selected",Toast.LENGTH_SHORT).show();
        else if (id == R.id.about)
            Toast.makeText(this, "About selected",Toast.LENGTH_SHORT).show();
        else if (id == R.id.exit)
            finish();
        else
            return super.onOptionsItemSelected(i);

        return true;
    }
}