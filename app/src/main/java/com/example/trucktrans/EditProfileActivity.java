package com.example.trucktrans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class EditProfileActivity extends AppCompatActivity {
    private EditText edtEditName, edtEditMobile;
    private Button btnSaveChanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        edtEditName = findViewById(R.id.edt_edit_name);
        edtEditMobile = findViewById(R.id.edt_edit_mobile);
        btnSaveChanges = findViewById(R.id.btn_save_changes);
        String userUid = getIntent().getStringExtra("userUid");
        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("Registered users").child(userUid);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String name = snapshot.child("name").getValue(String.class);
                    String mobile = snapshot.child("mobile").getValue(String.class);
                    edtEditName.setText(name);
                    edtEditMobile.setText(mobile);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
       /* btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = edtEditName.getText().toString();
                String newMobile = edtEditMobile.getText().toString();
                Log.d("EditProfileActivity", "New Name: " + newName);
                Log.d("EditProfileActivity", "New Mobile: " + newMobile);
                userReference.child("fullname").setValue(newName);
                userReference.child("mobile").setValue(newMobile);
                Toast.makeText(EditProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
        */
        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = edtEditName.getText().toString();
                String newMobile = edtEditMobile.getText().toString();
                if (newName.isEmpty()) {
                    // Display a toast message for an empty name
                    Toast.makeText(EditProfileActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (newMobile.isEmpty()) {
                    // Display a toast message for an empty mobile
                    Toast.makeText(EditProfileActivity.this, "Mobile cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    // Both fields are non-empty, proceed with the update
                    Log.d("EditProfileActivity", "New Name: " + newName);
                    Log.d("EditProfileActivity", "New Mobile: " + newMobile);
                    userReference.child("fullname").setValue(newName);
                    userReference.child("mobile").setValue(newMobile);
                    Toast.makeText(EditProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
