package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CarDetails extends AppCompatActivity {
    TextView modelName;
    TextView engineNumber;
    TextView maker;
    TextView ownerName;
    MaterialButton submitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        modelName = findViewById(R.id.model);
        engineNumber = findViewById(R.id.engineno);
        maker = findViewById(R.id.maker);
        ownerName = findViewById(R.id.ownername);
        submitbtn = findViewById(R.id.submitbtn);

        ArrayList<Car>car = new ArrayList<>();

        submitbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String modeln =  modelName.getText().toString();
                String enginen = engineNumber.getText().toString();
                String makeR = maker.getText().toString();
                String ownern = ownerName.getText().toString();
                Boolean check = validationInfo(modeln,enginen,makeR,ownern);
                if(check == true) {
                    Car c = new Car();
                    c.engineNumber = enginen;
                    c.maker = makeR;
                    c.modelName = modeln;
                    c.ownerName = ownern;
                    car.add(c);
                    System.out.println(c.engineNumber);
                }
            }
        });

    }
    private Boolean validationInfo(String modeln, String enginen,String makeR, String owern){
        if(modeln.length() == 0){
            modelName.requestFocus();
            modelName.setError("Field cannot be empty");
            return false;
        }else if(enginen.length() == 0) {
            engineNumber.requestFocus();
            engineNumber.setError("Field cannot be empty");
            return false;
        }else if(makeR.length()==0)
        {
            maker.requestFocus();
            maker.setError("Field cannot be empty");
            return false;
        }else if(owern.length()==0){
            ownerName.requestFocus();
            ownerName.setError("Field cannot be empty");
            return false;
        }else {
            Toast.makeText(CarDetails.this,"Submission Successfull",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}