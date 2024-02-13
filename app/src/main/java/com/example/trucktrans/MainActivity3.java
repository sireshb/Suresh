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
public class MainActivity3 extends AppCompatActivity {
    TextView textViewWelcome, textViewFullName, textViewEmail, textViewDoB, textViewcountry, textViewMobile;
    String fullName, email, doB, country, mobile,ImageUri,profilePicUrl;
    ImageView imageView;
    Spinner spinnerA,spinnerB,spinnerC,spinnerD,spinnerE;
    FirebaseAuth authProfile;

    //recycleview data
    Button btninsert2;
    EditText varea2,vcity2;
    TextView td2,name2,mob2;
    DatabaseReference dbUsers;
    String type2;
    String[] type2names= {"Vehicle type","Lorry","Trailor","Tanker","Container"};
    String size2;
    String[] size2names={ "Vehicle size","6 Tyres","10 Tyres","12 Tyres","14 Tyres","16 Tyres","18 Tyres","20 Tyres","22 tyres","26 Tyres","specialVehicle"};
    String body2;
    String[] body2names={"bodyType","platFarm","doreBody","semiLowBed","lowBed","nobodyType"};
    String desti2;
    String[] desti2names={"Destination", "ANDHRA", "ARUNACHAL", "ASSAM", "BIHAR",
            "CHATTISGARH", "DELHI", "GOA", "GUJARAT", "HARYANA", "HIMACHAL", "JHARKHAND",
            "JK", "KARNATAKA", "KERALA", "MAHARASHTRA", "MANIPUR", "MEGHALAYA", "MIZORAM",
            "MP", "NAGALAND", "ODISHA", "PUNJAB", "RAJASTHAN", "SIKKIM", "TAMILNADU", "TELANGANA",
            "TRIPURA", "UP", "UTTARAKHAND", "WBENGAL","NEPAL","BHUTAN"};
    String vstate2;
    String[] vstate2names={"VehicleLocatedState", "ANDHRA", "ARUNACHAL", "ASSAM", "BIHAR",
            "CHATTISGARH", "DELHI", "GOA", "GUJARAT", "HARYANA", "HIMACHAL", "JHARKHAND",
            "JK", "KARNATAKA", "KERALA", "MAHARASHTRA", "MANIPUR", "MEGHALAYA", "MIZORAM",
            "MP", "NAGALAND", "ODISHA", "PUNJAB", "RAJASTHAN", "SIKKIM", "TAMILNADU", "TELANGANA",
            "TRIPURA", "UP", "UTTARAKHAND", "WBENGAL","NEPAL","BHUTAN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textViewFullName = findViewById(R.id.textview_show_fullname2);
        textViewEmail = findViewById(R.id.textview_show_email2);
        textViewDoB = findViewById(R.id.textview_show_dob2);
        textViewcountry = findViewById(R.id.textview_show_country2);
        textViewMobile = findViewById(R.id.textview_show_mobile2);
        imageView = findViewById(R.id.imageview_profile_dp2);
        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if (firebaseUser == null) {
            Toast.makeText(this, "something went wrong user details are not available", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity3.this,MainActivity.class);
            startActivity(intent);
        } else {
            showUserProfile(firebaseUser);
        }
    }
    //new
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
                    Toast.makeText(MainActivity3.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity3.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
//new//
        td2=findViewById(R.id.edttd2);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd-MMM-yyyy  hh:mm:ss a");
        String dateTime=simpleDateFormat.format(calendar.getTime());
        td2.setText(dateTime);
        btninsert2=findViewById(R.id.btninsert2);
        mob2=findViewById(R.id.textview_show_mobile2);
        name2 = findViewById(R.id.textview_show_fullname2);
        varea2 = findViewById(R.id.edtvarea2);
        vcity2 = findViewById(R.id.edtvcity2);
        dbUsers= FirebaseDatabase.getInstance().getReference();
        spinnerA = findViewById(R.id.spinnerA);
        ArrayAdapter<String> adapterA = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, type2names);
        spinnerA.setAdapter(adapterA);
        spinnerB = findViewById(R.id.spinnerB);
        ArrayAdapter<String> adapterB = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, size2names);
        spinnerB.setAdapter(adapterB);
        spinnerC = findViewById(R.id.spinnerC);
        ArrayAdapter<String> adapterC = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, body2names);
        spinnerC.setAdapter(adapterC);
        spinnerD = findViewById(R.id.spinnerD);
        ArrayAdapter<String> adapterD = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, desti2names);
        spinnerD.setAdapter(adapterD);
        spinnerE = findViewById(R.id.spinnerE);
        ArrayAdapter<String> adapterE = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, vstate2names);
        spinnerE.setAdapter(adapterE);
        btninsert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if all fields are filled
                if(TextUtils.isEmpty(varea2.getText().toString())
                        || TextUtils.isEmpty(vcity2.getText().toString())){
                    // display a Toast message if any field is empty
                    Toast.makeText(MainActivity3.this, "Please fill in all the items", Toast.LENGTH_SHORT).show();
                } else {
                    InsertData();
                }
            }
        });
    }
    private void InsertData() {
        String user2td2=td2.getText().toString();
        String user2mob2=mob2.getText().toString();
        String user2name2= name2.getText().toString();
        String user2type2=spinnerA.getSelectedItem().toString();
        String user2size2=spinnerB.getSelectedItem().toString();
        String user2varea2=varea2.getText().toString();
        String user2vcity2=vcity2.getText().toString();
        String user2vstate2=spinnerE.getSelectedItem().toString();
        String user2desti2 = spinnerD.getSelectedItem().toString();
        String user2body2=spinnerC.getSelectedItem().toString();
        String id=dbUsers.push().getKey();

        User2 user2 = new User2(user2mob2,user2name2 ,user2type2,user2size2,user2varea2,user2vcity2,user2vstate2,user2desti2,user2body2,user2td2,profilePicUrl);
        dbUsers.child("users2").child(id).setValue(user2).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity3.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity3.this, "error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
