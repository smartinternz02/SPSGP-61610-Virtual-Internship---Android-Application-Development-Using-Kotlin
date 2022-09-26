package com.example.loginanddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText USERNAME,PASSWORD;
    Button loginButton;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        USERNAME=findViewById(R.id.loginusername);
        PASSWORD=findViewById(R.id.loginpassword);
        loginButton=findViewById(R.id.loginbutton);

        myDb =new DataBaseHelper(this);

       loginUser();

    }
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = USERNAME.getText().toString();
                String pass = PASSWORD.getText().toString();
                if (user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this,"Please enter all field mentioned",Toast.LENGTH_SHORT).show();
                else{
                    Boolean var =myDb.checkUser(user,pass);
                    if(var){
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Login Failed !!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}