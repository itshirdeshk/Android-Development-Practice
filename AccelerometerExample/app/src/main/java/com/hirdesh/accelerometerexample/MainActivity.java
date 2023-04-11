package com.hirdesh.accelerometerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView accelerometerValue;
    TextView proximitySensorValue;
    TextView lightSensorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometerValue = findViewById(R.id.accelerometerValue);
        proximitySensorValue = findViewById(R.id.proximityValue);
        lightSensorValue = findViewById(R.id.lightValue);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {
            Sensor acceleoSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (acceleoSensor != null) {
                sensorManager.registerListener(this, acceleoSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

            Sensor proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if (proximity != null) {
                sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
            }

            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if (lightSensor != null) {
                sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

        } else {
            Toast.makeText(this, "Sensor Service not detected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometerValue.setText("X : " + sensorEvent.values[0] + " Y : " + sensorEvent.values[1] + " Z : " + sensorEvent.values[2]);
        }

        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximitySensorValue.setText("Value of the Proximity Sensor is : " + sensorEvent.values[0]);
        }

        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightSensorValue.setText("Values of Light Sensor is " + sensorEvent.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

