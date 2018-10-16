package com.example.shyam.firebaseauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class WEEKRECORD extends AppCompatActivity {
 TextView Monday_steps;
 TextView MOnday_cal;
 TextView Tuesday_steps;
 TextView Tuesday_cal;
    TextView Wednesday_steps;
    TextView Wednesday_cal;
    TextView Thursday_steps;
    TextView Thursday_cal;
    TextView Friday_steps;
    TextView Friday_cal;
    TextView Saturday_steps;
    TextView Saturday_cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekrecord);
        Monday_steps = (TextView)findViewById(R.id.Monday_steps);
        MOnday_cal = (TextView)findViewById(R.id.Monday_calories);

        Tuesday_steps=(TextView)findViewById(R.id.Tuesday_steps);
        Tuesday_cal=(TextView)findViewById(R.id.Tuesday_calories);

        Wednesday_steps  =(TextView)findViewById(R.id.wednesday_steps);
        Wednesday_cal=(TextView)findViewById(R.id.Wednesday_calories);


        Thursday_steps  =(TextView)findViewById(R.id.Thursday_steps);
        Thursday_cal=(TextView)findViewById(R.id.Thursday_calories);


        Friday_steps  =(TextView)findViewById(R.id.friday_steps);
        Friday_cal=(TextView)findViewById(R.id.friday_calories);

        Saturday_steps  =(TextView)findViewById(R.id.Saturday_steps);
        Saturday_cal=(TextView)findViewById(R.id.Saturday_calories);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);





        if(day ==2) {
            SharedPreferences sharedprefrences = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedprefrences.edit();

            int steps = sharedprefrences.getInt("Sum", 20);
            String step =  "STEPS :"+Integer.toString(steps);

            Monday_steps.setText(step);
            MOnday_cal.setText(step);

        }if(day ==3) {
            SharedPreferences sharedprefrences = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedprefrences.edit();

            int steps = sharedprefrences.getInt("Sum", 20);
            String step =  "STEPS :"+Integer.toString(steps);
            Tuesday_steps.setText(step);
            Tuesday_cal.setText(step);

        }


        if(day ==4) {
            SharedPreferences sharedprefrences = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedprefrences.edit();

            int steps = sharedprefrences.getInt("Sum", 20);
            String step =  "STEPS :"+Integer.toString(steps);
            Wednesday_steps.setText(step);
            Wednesday_cal.setText(step);}

        if(day ==5) {
            SharedPreferences sharedprefrences = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedprefrences.edit();

            int steps = sharedprefrences.getInt("Sum", 20);
            String step =  "STEPS :"+Integer.toString(steps);
            Thursday_steps.setText(step);
            Thursday_cal.setText(step);

        }if(day ==6) {
            SharedPreferences sharedprefrences = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedprefrences.edit();

            int steps = sharedprefrences.getInt("Sum", 20);
            String step =  "STEPS :"+Integer.toString(steps);
            Friday_steps.setText(step);
            Friday_cal.setText(step);

        }
        if(day ==7) {
            SharedPreferences sharedprefrences = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedprefrences.edit();

            int steps = sharedprefrences.getInt("Sum", 20);
            String step =  "STEPS :"+Integer.toString(steps);
            Saturday_steps.setText(step);
            Saturday_cal.setText(step);

        }





    }
}
