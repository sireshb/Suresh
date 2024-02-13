package com.example.trucktrans;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Register extends AppCompatActivity {
    private EditText edt_register_fullname, edt_register_dob, edt_register_email, edt_register_password,
            edt_register_confirm_password, edt_register_mob;
    private ProgressBar progressBar;
    private RadioGroup radioGroup_Register_country;
    private RadioButton radioButtonRegistercountrySelected;
    private static final String TAG = "Register";
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toast.makeText(this, "You can register now", Toast.LENGTH_SHORT).show();
        edt_register_fullname = findViewById(R.id.edt_register_Fullname);
        edt_register_email = findViewById(R.id.edt_register_Email);
        edt_register_dob = findViewById(R.id.edt_register_dob);
        edt_register_mob = findViewById(R.id.edt_register_mob);
        edt_register_password = findViewById(R.id.edt_register_password);
        edt_register_confirm_password = findViewById(R.id.edt_register_confirm_password);
        radioGroup_Register_country = findViewById(R.id.radio_group_register_country);
        radioGroup_Register_country.clearCheck();
        btnRegister = findViewById(R.id.btnRegister);
        progressBar = findViewById(R.id.progressbar);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOccupationId = radioGroup_Register_country.getCheckedRadioButtonId();
                radioButtonRegistercountrySelected = findViewById(selectedOccupationId);
                String textFullname = edt_register_fullname.getText().toString();
                String textEmail = edt_register_email.getText().toString();
                String textDob = edt_register_dob.getText().toString();
                String textMobile = edt_register_mob.getText().toString();
                String textPwd = edt_register_password.getText().toString();
                String textConfirmPwd = edt_register_confirm_password.getText().toString();
                String textOccupation;
                if (TextUtils.isEmpty(textFullname)) {
                    Toast.makeText(Register.this, "Please Enter Fullname", Toast.LENGTH_SHORT).show();
                    edt_register_fullname.setError("Fullname is Required");
                    edt_register_fullname.requestFocus();
                } else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(Register.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
                    edt_register_email.setError("Emil is Required");
                    edt_register_email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(Register.this, "Please Reenter  your Email", Toast.LENGTH_SHORT).show();
                    edt_register_email.setError("Valid Emil is Required");
                    edt_register_email.requestFocus();
                } else if (TextUtils.isEmpty(textDob)) {
                    Toast.makeText(Register.this, "Please enter  your date of birth", Toast.LENGTH_SHORT).show();
                    edt_register_dob.setError("DateofBirth is Required");
                    edt_register_dob.requestFocus();
                } else if (radioGroup_Register_country.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Register.this, "Please enter  your Occupation", Toast.LENGTH_SHORT).show();
                    radioButtonRegistercountrySelected.setError("Occupation is Required");
                    radioButtonRegistercountrySelected.requestFocus();
                } else if (TextUtils.isEmpty(textMobile)) {
                    Toast.makeText(Register.this, "Please enter  your mobile number", Toast.LENGTH_SHORT).show();
                    edt_register_mob.setError("Mobile No is Required");
                    edt_register_mob.requestFocus();
                } else if (textMobile.length() != 10) {
                    Toast.makeText(Register.this, "Please Re_enter  your 10digit mob number", Toast.LENGTH_SHORT).show();
                    edt_register_mob.setError("mobile should be 10 digits");
                    edt_register_mob.requestFocus();
                } else if (TextUtils.isEmpty(textPwd)) {
                    Toast.makeText(Register.this, "Please enter  your PassWord", Toast.LENGTH_SHORT).show();
                    edt_register_password.setError("PassWord is Required");
                    edt_register_password.requestFocus();
                } else if (textPwd.length() < 6) {
                    Toast.makeText(Register.this, "PassWord should be at least 6 digits", Toast.LENGTH_SHORT).show();
                    edt_register_password.setError("password too weak");
                    edt_register_password.requestFocus();
                } else if (TextUtils.isEmpty(textConfirmPwd)) {
                    Toast.makeText(Register.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                    edt_register_confirm_password.setError("password confirmation is Required");
                    edt_register_confirm_password.requestFocus();
                } else if (!textPwd.equals(textConfirmPwd)) {
                    Toast.makeText(Register.this, "Please same same password", Toast.LENGTH_SHORT).show();
                    edt_register_confirm_password.setError("password confirmation is required");
                    edt_register_confirm_password.requestFocus();
                    edt_register_password.clearComposingText();
                    edt_register_confirm_password.clearComposingText();
                } else {
                    textOccupation = radioButtonRegistercountrySelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    registerUser(textFullname, textEmail, textDob, textOccupation, textPwd, textMobile);
                }
            }
        });
    }
    private void registerUser(String textFullname, String textEmail, String textDob, String textcountry, String textPwd, String textMobile) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(textEmail, textPwd).addOnCompleteListener(Register.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "user Registerad successfully", Toast.LENGTH_SHORT).show();
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textFullname).build();
                            firebaseUser.updateProfile(profileChangeRequest);
                            // Upload default image to Firebase Storage
                            FirebaseStorage storage = FirebaseStorage.getInstance();
                            StorageReference storageRef = storage.getReference();
                            StorageReference defaultImageRef = storageRef.child("profile_images/default_image.jpg");
                            // Upload the default image from drawable to Firebase Storage
                            defaultImageRef.putFile(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.b61411fce1f02a043392c808f577576a))
                                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                // Get the download URL of the uploaded image
                                                defaultImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                    @Override
                                                    public void onSuccess(Uri uri) {
                                                        // Associate the download URL with the user's profile
                                                        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                                                .setDisplayName(textFullname)
                                                                .setPhotoUri(uri)
                                                                .build();
                                                        firebaseUser.updateProfile(profileChangeRequest);
                                                        ReadwriteUserDetails writeUserDetails = new ReadwriteUserDetails(textDob, textcountry, textMobile, textFullname);
                                                        DatabaseReference referenceprofile = FirebaseDatabase.getInstance().getReference("Registered users");
                                                        referenceprofile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {
                                                                    firebaseUser.sendEmailVerification();
                                                                    Toast.makeText(Register.this, "user registration successfully verify your email", Toast.LENGTH_SHORT).show();
                                                                    Intent intent = new Intent(Register.this, UserProfile.class);
                                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                    startActivity(intent);
                                                                    finish();
                                                                } else {
                                                                    Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                                }
                                                                progressBar.setVisibility(View.GONE);
                                                            }
                                                        });
                                                    }
                                                });
                                            } else {
                                                // Handle default image upload failure
                                                Log.e(TAG, "Default image upload failed: " + task.getException().getMessage());
                                                // Continue without setting the default image
                                                ReadwriteUserDetails writeUserDetails = new ReadwriteUserDetails(textDob, textcountry, textMobile, textFullname);
                                                DatabaseReference referenceprofile = FirebaseDatabase.getInstance().getReference("Registered users");
                                                referenceprofile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            firebaseUser.sendEmailVerification();
                                                            Toast.makeText(Register.this, "user registration successfully verify your email", Toast.LENGTH_SHORT).show();
                                                            Intent intent = new Intent(Register.this, UserProfile.class);
                                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(intent);
                                                            finish();
                                                        } else {
                                                            Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                        }
                                                        progressBar.setVisibility(View.GONE);
                                                    }
                                                });
                                            }
                                        }
                                    });
                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                edt_register_password.setError("Your password is too weak kindly use a mix of alphabets, numbers, and special characters");
                                edt_register_password.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                edt_register_password.setError("Your email is invalid or already in use. Kindly re-enter.");
                                edt_register_password.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e) {
                                edt_register_password.setError("A user is already registered with this email. Use another email.");
                                edt_register_password.requestFocus();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
