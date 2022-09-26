package com.example.loginanddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText EMAIL,USERNAME,PASSWORD;
    Button SignUpButton;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EMAIL =findViewById(R.id.signupemail);
        USERNAME=findViewById(R.id.signupusername);
        PASSWORD=findViewById(R.id.signuppassword);

        SignUpButton=findViewById(R.id.signupbutton);

        myDb=new DataBaseHelper(this);
        insertUser();
    }
    private void insertUser(){

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = USERNAME.getText().toString();
                String pass = PASSWORD.getText().toString();
                String email = EMAIL.getText().toString();
                if (user.equals("")||pass.equals("")||email.equals("")) {
                    Toast.makeText(SignUpActivity.this, "Please enter all the fields mentioned", Toast.LENGTH_SHORT).show();

                }else{
                    boolean i=myDb.check(user);
                    if (i==false) {
                        boolean var = myDb.registerUser(user, pass, email);

                        if (var == true) {

                            Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(SignUpActivity.this, "Registration Error!!!!", Toast.LENGTH_SHORT).show();
                    }
                }
                }

        });
    }
}