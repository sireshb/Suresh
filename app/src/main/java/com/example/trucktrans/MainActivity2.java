package com.example.trucktrans;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
public class MainActivity2 extends AppCompatActivity {
    TextView textViewFullName, textViewEmail, textViewcountry, textViewDoB, textViewMobile;
    ImageView imageView;
    String fullName, email, doB, country, mobile, ImageUri,profilePicUrl;
    FirebaseAuth authProfile;

    //recycleview data
    Button btninsert;
    EditText larea, lcity, uarea, ucity, disc, rate;
    TextView td, name, mob;
    Spinner spinner1, spinner2, spinner3;
    String lstate;
    String[] lstatenames = {"SelectLoadingState", "ANDHRA", "ARUNACHAL", "ASSAM", "BIHAR",
            "CHATTISGARH", "DELHI", "GOA", "GUJARAT", "HARYANA", "HIMACHAL", "JHARKHAND",
            "JK", "KARNATAKA", "KERALA", "MAHARASHTRA", "MANIPUR", "MEGHALAYA", "MIZORAM",
            "MP", "NAGALAND", "ODISHA", "PUNJAB", "RAJASTHAN", "SIKKIM", "TAMILNADU", "TELANGANA",
            "TRIPURA", "UP", "UTTARAKHAND", "WBENGAL","NEPAL","BHUTAN"};
    String ustate;
    String[] ustatenames = {"SelectUnLoadingState", "ANDHRA", "ARUNACHAL", "ASSAM", "BIHAR",
            "CHATTISGARH", "DELHI", "GOA", "GUJARAT", "HARYANA", "HIMACHAL", "JHARKHAND",
            "JK", "KARNATAKA", "KERALA", "MAHARASHTRA", "MANIPUR", "MEGHALAYA", "MIZORAM",
            "MP", "NAGALAND", "ODISHA", "PUNJAB", "RAJASTHAN", "SIKKIM", "TAMILNADU", "TELANGANA",
            "TRIPURA", "UP", "UTTARAKHAND", "WBENGAL","NEPAL","BHUTAN"};
    String req;
    String[] reqnames = {"RequiredVehicle", "Lorry", "Trailor", "Tanker", "Container"};
    DatabaseReference databaseUsers;
    //recycle end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewFullName = findViewById(R.id.textview_show_fullname);
        textViewEmail = findViewById(R.id.textview_show_email);
        textViewDoB = findViewById(R.id.textview_show_dob);
        textViewcountry = findViewById(R.id.textview_show_country);
        textViewMobile = findViewById(R.id.textview_show_mobile);
        imageView = findViewById(R.id.imageview_profile_dp);
        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if (firebaseUser == null) {
            Toast.makeText(this, "something went wrong user details are not available", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        } else {
            showUserProfile(firebaseUser);
        }
    }
    private void showUserProfile(FirebaseUser firebaseUser) {
        String userId = firebaseUser.getUid();
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered users");
        referenceProfile.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadwriteUserDetails readwriteUserDetails = snapshot.getValue(ReadwriteUserDetails.class);
                if (readwriteUserDetails != null) {
                    fullName = readwriteUserDetails.fullname;
                    email = firebaseUser.getEmail();
                    doB = readwriteUserDetails.dob;
                    country = readwriteUserDetails.country;
                    mobile = readwriteUserDetails.mobile;
                    textViewFullName.setText(fullName);
                    textViewEmail.setText(email);
                    textViewDoB.setText(doB);
                    textViewcountry.setText(country);
                    textViewMobile.setText(mobile);
                    Uri uri = firebaseUser.getPhotoUrl();
                    Picasso.get().load(uri).into(imageView);
                    // Set the profilePicUrl with the URL of the profile picture
                    profilePicUrl = uri.toString();
                } else {
                    Toast.makeText(MainActivity2.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity2.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        //Recycler view data
        td = findViewById(R.id.edttd);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy  hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        td.setText(dateTime);

        btninsert = findViewById(R.id.btninsert);
        mob = findViewById(R.id.textview_show_mobile);
        name = findViewById(R.id.textview_show_fullname);
        larea = findViewById(R.id.edtlarea);
        lcity = findViewById(R.id.edtlcity);
        uarea = findViewById(R.id.edtuarea);
        ucity = findViewById(R.id.edtucity);
        disc = findViewById(R.id.edtdisc);
        rate = findViewById(R.id.edtrate);
//spinner
        spinner1 = findViewById(R.id.spinner1);
        // state=spinner1.getSelectedItem().toString();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, lstatenames);
        spinner1.setAdapter(adapter);
        spinner2 = findViewById(R.id.spinner2);
        // state=spinner1.getSelectedItem().toString();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ustatenames);
        spinner2.setAdapter(adapter2);
        spinner3 = findViewById(R.id.spinner3);
        // state=spinner1.getSelectedItem().toString();
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, reqnames);
        spinner3.setAdapter(adapter3);
        //spinnere
        databaseUsers = FirebaseDatabase.getInstance().getReference();
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if all fields are filled
                if(TextUtils.isEmpty(larea.getText().toString())
                        || TextUtils.isEmpty(lcity.getText().toString())
                        || TextUtils.isEmpty(uarea.getText().toString())
                        || TextUtils.isEmpty(ucity.getText().toString())
                        || TextUtils.isEmpty(disc.getText().toString())) {
                    // display a Toast message if any field is empty
                    Toast.makeText(MainActivity2.this, "Please fill in all the items", Toast.LENGTH_SHORT).show();
                } else {
                    InsertData();
                }
            }
        });
    }
    private void InsertData() {
        String usertd = td.getText().toString();
        String usermob = mob.getText().toString();
        String username = name.getText().toString();
        String userreq = spinner3.getSelectedItem().toString();
        String userlarea = larea.getText().toString();
        String userlstate=spinner1.getSelectedItem().toString();
        String userlcity=lcity.getText().toString();
        String useruarea = uarea.getText().toString();
        String userucity = ucity.getText().toString();
        String userustate = spinner2.getSelectedItem().toString();
        String userdisc = disc.getText().toString();
        String userrate = rate.getText().toString();
        String id = databaseUsers.push().getKey();
        User user = new User(usermob,username,userreq,userlarea,userlcity,userlstate,useruarea,userucity,userustate,userdisc,userrate,usertd,profilePicUrl );
        databaseUsers.child("users").child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity2.this, "data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void saveImageURLToDatabase(String profilePicUrl) {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("users").child(userId);
            databaseUsers.child("profilePictureUrl").setValue(profilePicUrl)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(this, "Profile picture uploaded and saved successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Failed to save profile picture URL", Toast.LENGTH_SHORT).show();
                    });
        }
    }
}
