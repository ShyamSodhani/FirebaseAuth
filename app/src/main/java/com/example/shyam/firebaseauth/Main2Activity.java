package com.example.shyam.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void checksteps(View view){
        Intent intent =new Intent(this,Pedo.class);
        startActivity(intent);

    }


    public void checkbmi(View view)
    {
        Intent intent = new Intent(this,BMI.class);
        startActivity(intent);
    }

    public void Medichat(View view)
    {
        Intent intent = new Intent(this,Doctorchat.class);
        startActivity(intent);

    }



}
