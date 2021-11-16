package com.techjinny.futurepredtoday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.RegionIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://futurepredtoday-a31c1-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText name= findViewById(R.id.r_name);
        final EditText mobile= findViewById(R.id.r_mobile);
        final EditText email= findViewById(R.id.r_email);
        final Button register= findViewById(R.id.r_registerBtn);


        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("loading...");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                final String nameTxt = name.getText().toString();
                final String mobileTxt = mobile.getText().toString();
                final String emailTxt = email.getText().toString();


                if(nameTxt.isEmpty() || mobileTxt.isEmpty() || emailTxt.isEmpty()){
                    Toast.makeText(Register.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else{
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            progressDialog.dismiss();
                            if(snapshot.child("users").hasChild(mobileTxt)){
                                Toast.makeText(Register.this, "Mobile already exist", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("users").child(mobileTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(mobileTxt).child("name").setValue(nameTxt);

                                Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();

                                Intent intent  =  new Intent(Register.this, MainActivity.class);
                                intent.putExtra("mobile",mobileTxt);
                                intent.putExtra("name",nameTxt);
                                intent.putExtra("email",emailTxt);
                                startActivity(intent);
                                finish();
                            }
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}