package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MANIPUR extends AppCompatActivity {

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
        setContentView(R.layout.activity_manipur);

        uploading = findViewById(R.id.mnuploading);
        profilepic = findViewById(R.id.mnprofilepic);
        viewvehical=findViewById(R.id.mnviewvehical);
        uploadvehicle=findViewById(R.id.mnuploadvehical);
        viewloading=findViewById(R.id.mnviewloading);
        os=findViewById(R.id.mnos);
        progressBar = findViewById(R.id.progressBar);

        uploading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MANIPUR.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MANIPUR.this,Conditions.class);
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
                        Intent intent = new Intent(MANIPUR.this,ManipurVehicle.class);
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
                        Intent intent = new Intent(MANIPUR.this, ManipurLoading.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 1000); // Adjust delay time as needed
            }
        });
        uploadvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MANIPUR.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MANIPUR.this,OtherState.class);
                startActivity(intent);
            }
        });
    }
}