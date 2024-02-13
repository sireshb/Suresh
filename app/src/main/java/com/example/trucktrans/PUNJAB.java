package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class PUNJAB extends AppCompatActivity {

    ImageView uploading,profilepic,viewvehical,viewloading,uploadvehicle,os;
    ProgressBar progressBar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjab);

        uploading = findViewById(R.id.pbuploading);
        profilepic = findViewById(R.id.pbprofilepic);
        viewvehical=findViewById(R.id.pbviewvehical);
        uploadvehicle=findViewById(R.id.pbuploadvehical);
        viewloading=findViewById(R.id.pbviewloading);
        os=findViewById(R.id.pbos);
        progressBar = findViewById(R.id.progressBar);

        uploading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PUNJAB.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PUNJAB.this,Conditions.class);
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
                        Intent intent = new Intent(PUNJAB.this,PunjabVehicle.class);
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
                        Intent intent = new Intent(PUNJAB.this, PunjabLoading.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 1000); // Adjust delay time as needed
            }
        });
        uploadvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PUNJAB.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PUNJAB.this,OtherState.class);
                startActivity(intent);
            }
        });
    }
}
