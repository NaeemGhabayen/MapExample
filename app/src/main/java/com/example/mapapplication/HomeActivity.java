package com.example.mapapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button btn_currentLocation, btn_search_map, btn_setPiker, btn_findRoute, btn_nerpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_currentLocation = findViewById(R.id.btn_currentLocation);
        btn_findRoute = findViewById(R.id.btn_findRoute);
        btn_setPiker = findViewById(R.id.btn_setPiker);
        btn_search_map = findViewById(R.id.btn_search_map);
        btn_nerpay = findViewById(R.id.btn_nerpay);

        btn_currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), curentLocationActivity.class));
            }
        });

        btn_setPiker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), setPickerActivity.class));
            }
        });
        btn_search_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), searchMapActivity.class));
            }
        });

        btn_findRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), drawRoutActivity.class));
            }
        });

        btn_nerpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), nerpyPlaceMapActivity.class));
            }
        });
    }
}