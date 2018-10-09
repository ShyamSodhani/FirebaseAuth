package com.example.shyam.firebaseauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

        TextView Weight ;
        TextView Height;
        TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }
    public void getresult(View view ){


        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        double weight= sharedPreferences.getInt("Weight",0);
        int height=  sharedPreferences.getInt("Height",0);
        String Wt = "Your wt is:"+weight ;
        String Ht= "Your ht is :"+height;
        Weight =(TextView)findViewById(R.id.bmi_weight);
        Weight.setText(Wt);
        Height= (TextView)findViewById(R.id.bmi_height);
        Height.setText(Ht);
        Double re = (weight*10000/(height*height)) ;
        String res = Double.toString(re);
        Result = (TextView)findViewById(R.id.bmi_result);
        Result.setText(res);



    }
}
