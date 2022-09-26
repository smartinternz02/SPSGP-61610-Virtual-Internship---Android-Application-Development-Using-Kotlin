package com.example.radiobuttonkanchan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.radiobuttonkanchan.R
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.radioMale == checkedId) "male" else "female"
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }
    }
}