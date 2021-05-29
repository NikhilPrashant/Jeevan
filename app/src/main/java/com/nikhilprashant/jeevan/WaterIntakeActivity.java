package com.nikhilprashant.jeevan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WaterIntakeActivity extends AppCompatActivity {

    Button btnAdd, btnSub, btnSet;
    Integer glass;
    TextView display, litreTotal, glassesTotal, litreConsumed, percentageConsumed, targetGlasses;
    EditText etQuantity, etTarget;
    Integer totalGlasses = 8, totalCapacity = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

        btnAdd = findViewById(R.id.addBtn);
        btnSub = findViewById(R.id.subBtn);
        btnSet = findViewById(R.id.btnSet2);
        display= findViewById(R.id.glasses);
        litreTotal = findViewById(R.id.litreTotal);
        glassesTotal = findViewById(R.id.glassesTotal);
        litreConsumed = findViewById(R.id.litreConsumed);
        percentageConsumed = findViewById(R.id.percentageConsumed);
        targetGlasses = findViewById(R.id.targetGlasses);
        etQuantity = findViewById(R.id.etQuantity);
        etTarget = findViewById(R.id.etTarget);

        etQuantity.setHint("Quantity");
        etTarget.setHint("Target");
        glass = 0;
        display.setText(String.valueOf(glass));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glass = glass + 1;
                display.setText(String.valueOf(glass));
                litreConsumed.setText(totalCapacity * glass + "mL");
                percentageConsumed.setText((((glass) * 100 / totalGlasses)) + "%");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (glass > 0) {
                    glass = glass - 1;
                    display.setText(String.valueOf(glass));
                    litreConsumed.setText(totalCapacity * glass + "mL");
                    percentageConsumed.setText((((glass) * 100 / totalGlasses)) + "%");
                }
                else {
                    glass = 0;
                }
            }
        });
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = etQuantity.getText().toString();
                String target = etTarget.getText().toString();
                totalCapacity = Integer.parseInt(quantity);
                totalGlasses = Integer.parseInt(target);
                litreTotal.setText(quantity);
                glassesTotal.setText(target);
                targetGlasses.setText("/" + target);
            }
        });
    }
}