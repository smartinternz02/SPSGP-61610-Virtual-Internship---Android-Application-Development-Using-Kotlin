package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText entervalue;
    TextView convertedvalue;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1=(Spinner)findViewById(R.id.sp1);
        sp2=(Spinner)findViewById(R.id.sp2);
        entervalue=(EditText) findViewById(R.id.entervalue);
        convertedvalue=(TextView) findViewById(R.id.convertedvalue);
        convert=(Button) findViewById(R.id.convert);

        String[] from={"USD"};
        ArrayAdapter ad =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to={"Saudi Riyal","Indian Rupees"};
        ArrayAdapter ad1=new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;

                Double amt=Double.parseDouble(entervalue.getText().toString());

                if (sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="Indian Rupees")
                {
                    tot=amt*70.0;
                    convertedvalue.setText(""+tot);
                }
                else if (sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="Saudi Riyal")
                {
                    tot=amt*3.75;
                    convertedvalue.setText(""+tot);
                }
            }
        });
    }
}