package com.mhacks11.triplet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import com.mhacks11.triplet.Model.User;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;
    Button btnSignUp;

    EditText editEmail, editUsername, editPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        users = database.getReference().child("Users");

        editUsername = (EditText) findViewById(R.id.username);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final User user = new User(editUsername.getText().toString(),
                        editEmail.getText().toString(),
                        editPassword.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(MainActivity.this, "The username already exists!",Toast.LENGTH_SHORT).show();
                        else{
                            users.child(user.getUsername()).setValue(user);
                            Toast.makeText(MainActivity.this, "Register Succesful!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, GameActivity.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Poop!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}