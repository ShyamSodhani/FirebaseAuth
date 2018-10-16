package com.example.shyam.firebaseauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
public class Pedo extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    //int count=0;



    TextView tv_steps;
    TextView distance;
    TextView calories;
    TextView time;

    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo);
        tv_steps=(TextView) findViewById(R.id.tv_steps);
        distance=(TextView) findViewById(R.id.distance);
        calories=(TextView) findViewById(R.id.calories);
        time=(TextView) findViewById(R.id.time);


        //height is 63 inches


        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int sum=sharedPreferences.getInt("Sum",0);
        tv_steps.setText(String.valueOf(sum));

        double weight= sharedPreferences.getInt("Weight",0);
        double height=  sharedPreferences.getInt("Height",0);

        double AvgStepsLenght=(height*0.413)/12; //avg foot step lenght in foot
        double EachStepInKilo=AvgStepsLenght/3280.84;
//     weight=62;
        double StepsInMile=5280/AvgStepsLenght;
        double CalorieperMile=0.57*weight;
        double CalorieperStep=CalorieperMile/StepsInMile;

        distance.setText(String.valueOf(Math.round(sum*EachStepInKilo*100)/100D));
        calories.setText(String.valueOf(Math.round(sum*CalorieperStep*100)/100D));

        String min=" min";
        String str2=String.valueOf(Math.round((sum*0.8)/60));
        String str3=str2.concat(min);


        time.setText(str3);


        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        //Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor!=null){
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);

        }
        else {
            Toast.makeText(this,"Sensor not found",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        running=false;

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        double weight= sharedPreferences.getInt("Weight",0);
        double height=  sharedPreferences.getInt("Height",0);
        int sum=sharedPreferences.getInt("Sum",0);

        //height is 63 inches
        double AvgStepsLenght=(height*0.413)/12; //avg foot step lenght in foot
        double EachStepInKilo=AvgStepsLenght/3280.84;
//     weight=62;
        double StepsInMile=5280/AvgStepsLenght;
        double CalorieperMile=0.57*weight;
        double CalorieperStep=CalorieperMile/StepsInMile;

        if(running){
            sum++;

            tv_steps.setText(String.valueOf(sum));

            distance.setText(String.valueOf(Math.round(sum*EachStepInKilo*100)/100D));
            calories.setText(String.valueOf(Math.round(sum*CalorieperStep*100)/100D));

            String min=" min";
            String str2=String.valueOf(Math.round((sum*0.8)/60));
            String str3=str2.concat(min);


            time.setText(str3);

//            SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
//            SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
//            preferencesEditor.putInt("sum", sum);
//            preferencesEditor.apply();

            SharedPreferences sharedPreferences2 = getApplicationContext().getSharedPreferences("userinfo",Context.MODE_PRIVATE)  ;
            SharedPreferences.Editor editor = sharedPreferences2.edit();
            editor.putInt("Sum", sum);
            editor.apply();

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

