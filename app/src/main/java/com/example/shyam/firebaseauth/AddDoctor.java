    package com.example.shyam.firebaseauth;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.text.Editable;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Spinner;
    import android.widget.Toast;

    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;

    public class AddDoctor extends AppCompatActivity {

        // Write a message to the databas
        //private FirebaseDatabase database;
       // private DatabaseReference myRef;

       // EditText mdoctorname;
       // Spinner typeofdoctor;
       // EditText mpatientperday;
         //Button msave;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_doctor);

            //database = FirebaseDatabase.getInstance();
       // myRef = FirebaseDatabase.getInstance().getReference();

//            mdoctorname =  findViewById(R.id.doctorname);
//            mpatientperday =  findViewById(R.id.patientperday);
//            msave =  findViewById(R.id.savedoctorsdata);
///
//            String doctorname = mdoctorname.getText().toString();
//            int numpatient = Integer.parseInt(mpatientperday.getText().toString());




            Spinner spinner = (Spinner) findViewById(R.id.typepofdoctor);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinner.setAdapter(adapter);



       /* msave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                Doctor doctor=new Doctor(mdoctorname.getText().toString(),Integer.parseInt(mpatientperday.getText().toString()));

                //FriendlyMessage friendlyMessage = new FriendlyMessage(mdoctorname,null);
//                myRef.child("doctor").setValue(doctor);
                Toast.makeText(getApplicationContext(),"data stored",Toast.LENGTH_SHORT).show();

                // Clear input box
               // mMessageEditText.setText("");
            }
        });

       // myRef.push().setValue(mdoctorname,mpatientperday);
    }*/


        /*public  void savedoctorsdata(View view)
        {
            myRef.push().setValue(mdoctorname,mpatientperday);
            Toast.makeText(getApplicationContext(),"data stored",Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(this,AddDoctor.class);
            //startActivity(intent);
        }*/

        }
    }
