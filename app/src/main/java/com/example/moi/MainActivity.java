package com.example.moi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moi.ui.perturb.Activity_Perturb;

public class MainActivity extends AppCompatActivity {

    Button perturb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perturb = findViewById(R.id.perturb);


        perturb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Perturb.class));
            }
        });
    }
}
