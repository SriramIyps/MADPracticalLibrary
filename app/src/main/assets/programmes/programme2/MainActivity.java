package com.example.myapplication2;




import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText name=findViewById(R.id.name);
        EditText pass=findViewById(R.id.password);
        EditText addr=findViewById(R.id.address);
        EditText age=findViewById(R.id.age);
        RadioGroup gender=findViewById(R.id.gender);
        DatePicker date=findViewById(R.id.date);
        Spinner course=findViewById(R.id.course);
        TextView result=findViewById(R.id.result);

        String[] courses={"BSc CS","BCA","BCom","BBA"};
        course.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,courses));

        findViewById(R.id.submit).setOnClickListener(v -> {
            int id=gender.getCheckedRadioButtonId();
            String g="Not selected";

            if(id!=-1)
                g=((RadioButton)findViewById(id)).getText().toString();

            String d=date.getDayOfMonth()+"/"+
                    (date.getMonth()+1)+"/"+date.getYear();

            result.setText("Name: "+name.getText()+
                    "\nPassword: "+pass.getText()+
                    "\nAddress: "+addr.getText()+
                    "\nGender: "+g+
                    "\nAge: "+age.getText()+
                    "\nDOB: "+d+
                    "\nCourse: "+course.getSelectedItem());
        });
    }
}