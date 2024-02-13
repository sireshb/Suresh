package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class TAMILNADU extends AppCompatActivity {

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
        setContentView(R.layout.activity_tamilnadu);

        uploading = findViewById(R.id.tnuploading);
        profilepic = findViewById(R.id.tnprofilepic);
        viewvehical=findViewById(R.id.tnviewvehical);
        uploadvehicle=findViewById(R.id.tnuploadvehical);
        viewloading=findViewById(R.id.tnviewloading);
        os=findViewById(R.id.tnos);
        progressBar = findViewById(R.id.progressBar);

        uploading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TAMILNADU.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TAMILNADU.this,Conditions.class);
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
                        Intent intent = new Intent(TAMILNADU.this,TamilnaduVehicle.class);
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
                        Intent intent = new Intent(TAMILNADU.this, TamilnaduLoading.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 1000); // Adjust delay time as needed
            }
        });
        uploadvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TAMILNADU.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TAMILNADU.this,OtherState.class);
                startActivity(intent);
            }
        });
    }
}
