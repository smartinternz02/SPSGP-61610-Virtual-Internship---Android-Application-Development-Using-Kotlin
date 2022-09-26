package com.example.logindatabase

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import com.example.logindatabase.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.logindatabase.Signup_Page
import android.widget.Toast
import com.example.logindatabase.home_page

class Login_App2 : AppCompatActivity() {
    var email: EditText? = null
    var password: EditText? = null
    var signup: TextView? = null
    var signin: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_app2)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signin = findViewById(R.id.button3)
        signup = findViewById(R.id.signup)
        val helper = Helper(this)
        signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Login_App2, Signup_Page::class.java)
            startActivity(intent)
        })
        signin.setOnClickListener(View.OnClickListener {
            val uemail: String
            val upassword: String
            uemail = email.getText().toString()
            upassword = password.getText().toString()
            if (uemail == "" || upassword == "") {
                Toast.makeText(this@Login_App2, "Pleae fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val validate = helper.checkemailandpassword(uemail, upassword)
                if (validate == true) {
                    Toast.makeText(this@Login_App2, "Login Successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Login_App2, home_page::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Login_App2, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}