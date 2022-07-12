package com.example.backgroundbaguion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
        daynightToggleListenerMethod();
        userTypeChangeListenerMethod(this);
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
        bgElement.setBackgroundColor(Color.RED);
    }

    public void userTypeChangeListenerMethod(Context c){
        Spinner spUsertype = (Spinner) findViewById(R.id.spUsertype);
        spUsertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String) spUsertype.getItemAtPosition(i);
                Toast.makeText(c, "You have selected " + selected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }




    public void daynightToggleListenerMethod() {
        Switch swday = (Switch) findViewById(R.id.swDay);
        swday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
                TextView lbName = (TextView) findViewById(R.id.tvLblName);
                EditText etName = (EditText) findViewById(R.id.etName);
                CheckBox cbCIT = (CheckBox) findViewById(R.id.cbCIT);
                Spinner spUsertype = (Spinner) findViewById(R.id.spUsertype);
                RadioButton rbMale = (RadioButton) findViewById(R.id.rbMale);
                RadioButton rbFemale = (RadioButton) findViewById(R.id.rbFemale);
                RadioButton rbFirst = (RadioButton)  findViewById(R.id.rbFirst);
                RadioButton rbSecond = (RadioButton)  findViewById(R.id.rbSecond);
                RadioButton rbThird = (RadioButton)  findViewById(R.id.rbThird);
                RadioButton rbFourth = (RadioButton)  findViewById(R.id.rbFourth);

                TextView[] texts = {swday, cbCIT, rbFemale, rbMale, rbFirst, rbSecond, rbThird, rbFourth, lbName, etName};

                boolean day = swday.isChecked();
                if (day) {
                    bgElement.setBackgroundColor(Color.WHITE);
                    for (TextView tv : texts){
                        tv.setTextColor(Color.BLACK);
                    }
                } else {
                    bgElement.setBackgroundColor(Color.BLACK);
                    for (TextView tv : texts){
                        tv.setTextColor(Color.WHITE);
                    }
                }
            }
        });
    }


    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);

                int color =((ColorDrawable) bgElement.getBackground()).getColor();
                if (color == Color.RED) {
                    bgElement.setBackgroundColor(Color.BLUE);
                } else {
                    bgElement.setBackgroundColor(Color.RED);
                }
            }
        });

    }
}