package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    MaterialButton loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =  findViewById(R.id.username);
        password =  findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userN = username.getText().toString();
                String passw = password.getText().toString();
                validationInfo(userN,passw);

            }
        });

    }
    private Boolean validationInfo(String usern, String passw){
        if(usern.length() == 0){
            username.requestFocus();
            username.setError("Field cannot be empty");
            return false;
        }else if(passw.length() == 0) {
            password.requestFocus();
            password.setError("Field cannot be empty");
            return false;
        }else if(usern.equals("admin") && passw.equals("admin"))
        {
            Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,CarDetails.class);
            startActivity(intent);

        }else{
            Toast.makeText(MainActivity.this,"Login Unsuccessfull",Toast.LENGTH_SHORT).show();
        }
        return  true;
    }

}