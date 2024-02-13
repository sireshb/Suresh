package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
public class Login extends AppCompatActivity {
    private EditText edtloginemail,edtloginpwd;
    private ProgressBar progressBar;
    private FirebaseAuth authProfile;
    private static final String TAG = "Login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtloginemail =findViewById(R.id.edt_login_email);
        edtloginpwd = findViewById(R.id.edt_login_pwd);
        progressBar = findViewById(R.id.progressB);
        authProfile = FirebaseAuth.getInstance();
        Button loginbtn =findViewById(R.id.button_login);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEmail = edtloginemail.getText().toString();
                String textPwd = edtloginpwd.getText().toString();
                if(TextUtils.isEmpty(textEmail)){
                    Toast.makeText(Login.this, "please enter your email", Toast.LENGTH_SHORT).show();
                    edtloginemail.setError("Email is Required");
                    edtloginemail.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(Login.this, "please Re-enter your Email", Toast.LENGTH_SHORT).show();
                    edtloginemail.setError("Valid Email is Required");
                    edtloginemail.requestFocus();
                }else if(TextUtils.isEmpty(textPwd)){
                    Toast.makeText(Login.this, "please enter your Password", Toast.LENGTH_SHORT).show();
                    edtloginpwd.setError("password is Required");
                    edtloginpwd.requestFocus();
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    loginUser(textEmail,textPwd);
                }
            }
        });

        TextView forgotPasswordTextView = findViewById(R.id.forgot_password_text); // Replace with your view ID

        // Set an OnClickListener for the "Forgot Password" TextView/Button
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(String email, String pwd) {
        authProfile.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Login.this,UserProfile.class);
                    startActivity(intent);
                }else {
                    try{
                        throw task.getException();
                    }catch(FirebaseAuthInvalidUserException e){
                        edtloginemail.setError("User does not exists or is no longer valid. please register again");
                        edtloginemail.requestFocus();
                    }catch(FirebaseAuthInvalidCredentialsException e) {
                        edtloginemail.setError("Invalid Credentials. kindly, check and re-enter.");
                        edtloginemail.requestFocus();
                    }catch(Exception e){
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(Login.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
