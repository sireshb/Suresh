package com.example.trucktrans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class StateSelect extends AppCompatActivity {
    private RadioGroup radioGroupState;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_select);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true);
        if (isFirstLaunch) {
            // This is the first launch, open MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish(); // Close the StateSelect activity
            // You can add any initialization code here if needed
            sharedPreferences.edit().putBoolean("isFirstLaunch", false).apply();
        }
        // Get the selected state ID from SharedPreferences
        int selectedId = sharedPreferences.getInt("selected_state_id", -1);
        if (selectedId != -1) {
            // A state has been selected, launch the corresponding state activity
            launchActivityForSelectedState(selectedId);
        } else {
            // This is the first launch or no state has been selected yet
            // Initialize the radioGroupState and btnState variables
            radioGroupState = findViewById(R.id.radio_group_state);
            Button btnState = findViewById(R.id.btnstate);
            btnState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the ID of the selected radio button
                    int selectedId = radioGroupState.getCheckedRadioButtonId();
                    // Update the selected state ID in SharedPreferences
                    sharedPreferences.edit().putInt("selected_state_id", selectedId).apply();
                    // Launch the corresponding activity or show a message
                    launchActivityForSelectedState(selectedId);
                }
            });
        }
    }
    // Helper method to launch the corresponding activity for the selected state
    private void launchActivityForSelectedState(int selectedId) {
        Intent intent= new Intent();
        switch (selectedId) {
            case R.id.radio_andhra:
                intent = new Intent(StateSelect.this, ANDHRA.class);
                break;
            case R.id.radio_arunachal:
                intent = new Intent(StateSelect.this, ARUNACHAL.class);
                break;
            case R.id.radio_assam:
                intent=new Intent(StateSelect.this, ASSAM.class);
                break;
            case R.id.radio_bihar:
                intent=new Intent(StateSelect.this, BIHAR.class);
                break;
            case R.id.radio_chattisgarh:
                intent=new Intent(StateSelect.this, CHATTISGARH.class);
                break;
            case R.id.radio_delhi:
                intent=new Intent(StateSelect.this, DELHI.class);
                break;
            case R.id.radio_goa:
                intent=new Intent(StateSelect.this, GOA.class);
                break;
            case R.id.radio_gujarat:
                intent=new Intent(StateSelect.this, GUJARAT.class);
                break;
            case R.id.radio_haryana:
                intent=new Intent(StateSelect.this, HARYANA.class);
                break;
            case R.id.radio_himachal:
                intent=new Intent(StateSelect.this, HIMACHAL.class);
                break;
            case R.id.radio_jharkhand:
                intent=new Intent(StateSelect.this, JHARKHAND.class);
                break;
            case R.id.radio_jk:
                intent=new Intent(StateSelect.this, JK.class);
                break;
            case R.id.radio_karnataka:
                intent=new Intent(StateSelect.this, KARNATAKA.class);
                break;
            case R.id.radio_kerala:
                intent=new Intent(StateSelect.this, KERALA.class);
                break;
            case R.id.radio_maharashtra:
                intent=new Intent(StateSelect.this, MAHARASHTRA.class);
                break;
            case R.id.radio_mp:
                intent=new Intent(StateSelect.this, MP.class);
                break;
            case R.id.radio_manipur:
                intent=new Intent(StateSelect.this, MANIPUR.class);
                break;
            case R.id.radio_meghalaya:
                intent=new Intent(StateSelect.this, MEGHALAYA.class);
                break;
            case R.id.radio_mizoram:
                intent=new Intent(StateSelect.this, MIZORAM.class);
                break;
            case R.id.radio_nagaland:
                intent=new Intent(StateSelect.this, NAGALAND.class);
                break;
            case R.id.radio_odisha:
                intent=new Intent(StateSelect.this, ODISHA.class);
                break;
            case R.id.radio_punjob:
                intent=new Intent(StateSelect.this, PUNJAB.class);
                break;
            case R.id.radio_rajasthan:
                intent=new Intent(StateSelect.this, RAJASTHAN.class);
                break;
            case R.id.radio_sikkim:
                intent=new Intent(StateSelect.this, SIKKIM.class);
                break;
            case R.id.radio_tamil:
                intent=new Intent(StateSelect.this, TAMILNADU.class);
                break;
            case R.id.radio_telangana:
                intent=new Intent(StateSelect.this, TELANGANA.class);
                break;
            case R.id.radio_tripura:
                intent=new Intent(StateSelect.this, TRIPURA.class);
                break;
            case R.id.radio_up:
                intent=new Intent(StateSelect.this, UP.class);
                break;
            case R.id.radio_uttarakhand:
                intent=new Intent(StateSelect.this, UTTARAKHAND.class);
                break;
            case R.id.radio_wbengal:
                intent=new Intent(StateSelect.this, WBENGAL.class);
                break;
            case R.id.radio_nepal:
                intent=new Intent(StateSelect.this, NEPAL.class);
                break;
            case R.id.radio_bhutan:
                intent=new Intent(StateSelect.this, BHUTAN.class);
                break;
            // Add cases for other states here
            default:
                // Display a toast message or handle the default case as needed
                Toast.makeText(this, "Please select a state", Toast.LENGTH_SHORT).show();
                return; // Do not finish the activity in this case
        }
        startActivity(intent);
        // Finish this activity to prevent going back to it
        finish();
    }
}
