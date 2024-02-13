package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class IconActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        // Delay for 2 seconds (2000 milliseconds) before starting StateSelect activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start StateSelect activity
                startActivity(new Intent(IconActivity.this, StateSelect.class));
                finish(); // Close the loading screen
            }
        }, 2000); // 2000 milliseconds delay
    }
}

