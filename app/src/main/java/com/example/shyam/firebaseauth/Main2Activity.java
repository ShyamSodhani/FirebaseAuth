package com.example.shyam.firebaseauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
          SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("userinnfo",Context.MODE_PRIVATE);
          SharedPreferences.Editor editor = sharedPreferences.edit();
          if(day==0) {
              editor.putInt("Monday", 0);
              editor.putInt("Tuesday", 0);
              editor.putInt("Wednesday", 0);
              editor.putInt("Thursday", 0);
              editor.putInt("Friday", 0);
              editor.putInt("Saturday", 0);
              editor.apply();
          }


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
     public  void WEEKRECORD(View view)
 {

     Intent intent = new Intent(this,WEEKRECORD.class);
     startActivity(intent);
 }

    public void bookappointment(View view)
    {
        Intent intent = new Intent(this,AddDoctor.class);
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.log_out_menu:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivity.class));

                break;

            case R.id.setting:

                startActivity(new Intent(this, Setting.class));
                break;


        }




        return true;
    }
}
