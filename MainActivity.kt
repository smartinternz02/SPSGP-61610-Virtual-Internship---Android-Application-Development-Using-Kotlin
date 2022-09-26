package com.example.calce

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calce.R

class MainActivity : AppCompatActivity() {
    var buzero: Button? = null
    var buOne: Button? = null
    var buTwo: Button? = null
    var buThree: Button? = null
    var buFour: Button? = null
    var buFive: Button? = null
    var buSix: Button? = null
    var bu7: Button? = null
    var buEigth: Button? = null
    var bunine: Button? = null
    var buAC: Button? = null
    var buequal: Button? = null
    var buDivide: Button? = null
    var buMultiply: Button? = null
    var buPercent: Button? = null
    var buDecimal: Button? = null
    var buPlus: Button? = null
    var buEvenodd: Button? = null
    var buMinus: Button? = null
    var buPrime: Button? = null
    var editText: EditText? = null
    var a: Double? = null
    var b: Double? = null
    var add = false
    var sub = false
    var mul = false
    var div = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<View>(R.id.editText) as EditText
        buzero = findViewById<View>(R.id.buzero) as Button
        buOne = findViewById<View>(R.id.buOne) as Button
        buTwo = findViewById<View>(R.id.buTwo) as Button
        buThree = findViewById<View>(R.id.buThree) as Button
        buFour = findViewById<View>(R.id.buFour) as Button
        buFive = findViewById<View>(R.id.buFive) as Button
        buSix = findViewById<View>(R.id.buSix) as Button
        bu7 = findViewById<View>(R.id.bu7) as Button
        buEigth = findViewById<View>(R.id.buEigth) as Button
        bunine = findViewById<View>(R.id.bunine) as Button
        buPlus = findViewById<View>(R.id.buPlus) as Button
        buMinus = findViewById<View>(R.id.buMinus) as Button
        buDivide = findViewById<View>(R.id.buDivide) as Button
        buMultiply = findViewById<View>(R.id.buMultiply) as Button
        buDecimal = findViewById<View>(R.id.buDecimal) as Button
        buequal = findViewById<View>(R.id.buequal) as Button
        buAC = findViewById<View>(R.id.buAC) as Button
        buPercent = findViewById<View>(R.id.buPercent) as Button
        buPrime = findViewById<View>(R.id.buPrime) as Button
        buEvenodd = findViewById<View>(R.id.buEvenodd) as Button
        buzero!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "0") }
        buOne!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "1") }
        buTwo!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "2") }
        buThree!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "3") }
        buFour!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "4") }
        buFive!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "5") }
        buSix!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "6") }
        bu7!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "7") }
        buEigth!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + "8") }
        bunine!!.setOnClickListener { editText!!.setText(editText.toString() + "9") }
        buDecimal!!.setOnClickListener { editText!!.setText(editText!!.text.toString() + ".") }
        buPlus!!.setOnClickListener {
            a = (editText!!.text.toString() + "").toDouble()
            add = true
            editText.setText(null)
        }
        buMinus!!.setOnClickListener {
            a = (editText!!.text.toString() + "").toDouble()
            sub = true
            editText.setText(null)
        }
        buMultiply!!.setOnClickListener {
            a = (editText!!.text.toString() + "").toDouble()
            mul = true
            editText.setText(null)
        }
        buDivide!!.setOnClickListener {
            a = (editText!!.text.toString() + "").toDouble()
            div = true
            editText.setText(null)
        }
        buAC!!.setOnClickListener { editText.setText(null) }
        buPrime!!.setOnClickListener {
            val n: Int
            n = editText!!.text.toString().toInt()
            var f = 0
            for (i in 2 until n) {
                if (n % i == 0) f = 1
                if (f == 0) {
                    editText!!.setText("prime number")
                } else {
                    editText!!.setText("not an prime number")
                }
            }
        }
        buEvenodd!!.setOnClickListener {
            val n: Int
            n = editText!!.text.toString().toInt()
            if (n % 2 == 0) editText!!.setText("Even number") else editText!!.setText("odd number")
        }
        buequal!!.setOnClickListener {
            b = (editText!!.text.toString() + "").toDouble()
            if (add == true) {
                editText!!.setText("" + (a!! + b!!))
                add = false
            }
            if (sub == true) {
                editText!!.setText((a!! - b!!).toString() + "")
                sub = false
            }
            if (mul == true) {
                editText!!.setText((a!! * b!!).toString() + "")
                mul = false
            }
            if (div == true) {
                if (b == 0.0) {
                    editText!!.setText("Infinite")
                } else {
                    editText!!.setText((a!! / b!!).toString() + "")
                }
                div = false
            }
        }
    }
}