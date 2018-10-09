package com.example.shyam.firebaseauth;

import android.content.Context;
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
    int count=0,sum;

    int height=63; //height is 63 inches
    double AvgStepsLenght=(height*0.413)/12; //avg foot step lenght in foot
    double EachStepInKilo=AvgStepsLenght/3280.84;
    double weight=62;
    double StepsInMile=5280/AvgStepsLenght;
    double CalorieperMile=0.57*weight;
    double CalorieperStep=CalorieperMile/StepsInMile;

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

        if(running){
            count++;
            tv_steps.setText(String.valueOf(count));

            distance.setText(String.valueOf(Math.round(count*EachStepInKilo*100)/100D));
            calories.setText(String.valueOf(Math.round(count*CalorieperStep*100)/100D));

            String min=" min";
            String str2=String.valueOf(Math.round((count*0.8)/60));
            String str3=str2.concat(min);


            time.setText(str3);
            //tv_steps.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

