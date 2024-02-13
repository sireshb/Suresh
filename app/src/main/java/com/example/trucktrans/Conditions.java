package com.example.trucktrans;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Conditions extends AppCompatActivity {
    Button btncon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);
        btncon=findViewById(R.id.btncon);
        btncon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Conditions.this,UserProfile.class);
                startActivity(intent);
            }
        });
    }
}
