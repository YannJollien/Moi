package com.example.moi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moi.ui.perturb.Activity_Perturb;
import com.example.moi.ui.perturb.mood.Activity_Mood;

public class MainActivity extends AppCompatActivity {

    Button perturb;
    Button mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perturb = findViewById(R.id.perturb);
        mood = findViewById(R.id.mood);


        perturb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Perturb.class));
            }
        });

        mood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Mood.class));
            }
        });
    }
}
