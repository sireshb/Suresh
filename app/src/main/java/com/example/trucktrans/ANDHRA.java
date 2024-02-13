package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Config;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.appcheck.BuildConfig;

import java.util.List;

public class ANDHRA extends AppCompatActivity {
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
        setContentView(R.layout.activity_andhra);

        uploading = findViewById(R.id.apuploading);
        profilepic = findViewById(R.id.approfilepic);
        viewvehical=findViewById(R.id.apviewvehical);
        uploadvehicle=findViewById(R.id.apuploadvehical);
         viewloading=findViewById(R.id.apviewloading);
        os=findViewById(R.id.apos);
        progressBar = findViewById(R.id.progressBar);


        uploading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ANDHRA.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ANDHRA.this,Conditions.class);
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
                        Intent intent = new Intent(ANDHRA.this, AndhraVehicle.class);
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
                        Intent intent = new Intent(ANDHRA.this, AndhraLoading.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 1000); // Adjust delay time as needed
            }
        });


        uploadvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ANDHRA.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ANDHRA.this,OtherState.class);
                startActivity(intent);
            }
        });


    }
}
