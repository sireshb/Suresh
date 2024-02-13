package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
public class ARUNACHAL extends AppCompatActivity {
    ImageView uploading,profilepic,viewvehical,viewloading,uploadvehicle,os;
    ProgressBar progressBar;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // Close all activities in the app's task
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arunachal);

        uploading = findViewById(R.id.aruploading);
        profilepic = findViewById(R.id.arprofilepic);
        viewvehical=findViewById(R.id.arviewvehical);
        uploadvehicle=findViewById(R.id.aruploadvehical);
        viewloading=findViewById(R.id.arviewloading);
        os=findViewById(R.id.aros);
        progressBar = findViewById(R.id.progressBar);
        uploading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ARUNACHAL.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ARUNACHAL.this,Conditions.class);
                startActivity(intent);
            }
        });
        viewvehical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ARUNACHAL.this,ArunachalVehicle.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 1000); // Adjust delay time as needed
            }
        });

        viewloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ARUNACHAL.this, ArunachalLoading.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 1000); // Adjust delay time as needed
            }
        });
        uploadvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ARUNACHAL.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ARUNACHAL.this,OtherState.class);
                startActivity(intent);
            }
        });
    }
}
