package com.example.logindatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Signup_Page extends AppCompatActivity {
    EditText username , email , password;
    TextView login;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS ,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS );


        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.button3);
        login=findViewById(R.id.login);

        Helper helper=new Helper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup_Page.this  , Login_App2.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname , uemail , upassword;
                uname=username.getText().toString();
                uemail=email.getText().toString();
                upassword=password.getText().toString();

                if(uname.equals("") || uemail.equals("") || upassword.equals("") ){
                    Toast.makeText(Signup_Page.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }else{
                    boolean i=helper.check_email(uemail);
                    if(i==false){

                        boolean insertfun=helper.insert_record(uname , uemail ,upassword);
                        if(insertfun==true){
                            Toast.makeText(Signup_Page.this, "Record Saved Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Signup_Page.this , Login_App2.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Signup_Page.this, "Failed to Saved Record", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Signup_Page.this, "Please choose another email", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });
    }
}