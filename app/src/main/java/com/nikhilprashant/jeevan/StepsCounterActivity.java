package com.nikhilprashant.jeevan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.nikhilprashant.jeevan.GlobalClass.stepsShare;

public class StepsCounterActivity extends AppCompatActivity implements SensorEventListener {

    TextView steps, stepsTarget, stepsPercentage;
    EditText etSteps;
    Button btnSet;
    SensorManager sensorManager;
    Double stepsDouble;
    Integer stepsInt;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_counter);
        stepsTarget = findViewById(R.id.stepsTarget);
        steps = findViewById(R.id.steps);
        stepsPercentage = findViewById(R.id.stepsPercentage);
        etSteps = findViewById(R.id.etSteps);
        btnSet = findViewById(R.id.btnSet);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String steps = etSteps.getText().toString();
                stepsTarget.setText("/" + steps);
                String stepsTa = stepsTarget.getText().toString();
                String stepsNumber  = stepsTa.replaceAll("[^0-9]", "");
                Double stepsD = Double.parseDouble(stepsNumber);
                Double stepsP = (stepsDouble / stepsD) * 100;
                Integer stepsInte = stepsP.intValue();
                String stepsPercent = new Integer(stepsInte).toString();
                stepsPercentage.setText(stepsPercent + "%");
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (isRunning) {
            stepsShare = String.valueOf(sensorEvent.values[0]);
            stepsDouble = Double.parseDouble(stepsShare);
            stepsInt = stepsDouble.intValue();
            String stepsData = new Integer(stepsInt).toString();
            steps.setText(stepsData);
            String stepsTa = stepsTarget.getText().toString();
            String stepsNumber  = stepsTa.replaceAll("[^0-9]", "");
            Double stepsD = Double.parseDouble(stepsNumber);
            Double stepsP = (stepsDouble / stepsD) * 100;
            Integer stepsInte = stepsP.intValue();
            String stepsPercent = new Integer(stepsInte).toString();
            stepsPercentage.setText(stepsPercent + "%");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRunning = true;
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(this, "Sensor Not Found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRunning = true;
    }
}