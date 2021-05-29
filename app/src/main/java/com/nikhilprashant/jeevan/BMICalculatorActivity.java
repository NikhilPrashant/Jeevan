package com.nikhilprashant.jeevan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculatorActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    Button btnCalc;
    TextView tvResult,tvRemarks;
    String remarks;

    final String normal = "No need to worry";
    final String obese = "Can do better";
    final String ovrWeight = "Urgent need to improve";
    final String underWeight = "Do better";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        etHeight = findViewById(R.id.height);
        etWeight= findViewById(R.id.weight);
        btnCalc = findViewById(R.id.calculate);
        tvResult = findViewById(R.id.result);
        tvRemarks = findViewById(R.id.remarks);

        etHeight.setHint("Height in CM");
        etWeight.setHint("Weight in Kgs");

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                closeKeyboard();
            }
        });
    }

    public void calculate(){
        String weight = etWeight.getText().toString();
        String height = etHeight.getText().toString();
        if(height.isEmpty()){
            etWeight.setError("Kindly enter your Weight");
        }
        else if(weight.isEmpty()){
            etHeight.setError("Kindly enter your Height");
        }
        else {
            float h = Float.parseFloat(height);
            float w = Float.parseFloat(weight);
            double a = (h * h * 0.01 * 0.01 );
            double bmi = w /a;

            if(bmi >= 18.5 && bmi <= 25.0)
            {
                remarks = normal;
                tvRemarks.setText("Normal");
            }
            else if( bmi <=18.5){
                remarks = underWeight;
                tvRemarks.setText("UnderWeight");
            }
            else if( bmi >= 25.0 && bmi <= 30.0){
                remarks = ovrWeight;
                tvRemarks.setText("ovrWeight");
            }
            else if( bmi >30.0){
                remarks = obese;
                tvRemarks.setText("obese");
            }
            int res = (int) bmi;
            tvResult.setText(String.valueOf(remarks));
        }
    }

    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}