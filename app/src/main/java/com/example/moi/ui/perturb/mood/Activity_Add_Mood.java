package com.example.moi.ui.perturb.mood;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.moi.R;
import com.example.moi.database.entity.Mood;
import com.example.moi.database.entity.Perturb;
import com.example.moi.ui.perturb.Activity_Add_Perturb;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class Activity_Add_Mood extends AppCompatActivity {

    private Spinner moods;
    private EditText editTextDate;
    private EditText editTextText;

    DatePickerDialog dpd;

    private Button save;
    Button date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);

        moods = (Spinner) findViewById(R.id.add_mood);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.moods_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        moods.setAdapter(adapter);


        editTextDate = findViewById(R.id.add_date_mood);
        editTextText = findViewById(R.id.add_text_mood);

        save = findViewById(R.id.button_save);
        date = findViewById(R.id.date_choser);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.mood_toolbar);
        setSupportActionBar(myChildToolbar);
        //myChildToolbar.setTitleTextColor(0xFFFFFFFF);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMood();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Activity_Add_Mood.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                        editTextDate.setText(mDayOfMonth + ".0" +mMonth+ "." + mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

    }

    private void saveMood(){
        String mood = moods.getSelectedItem().toString();
        String date = editTextDate.getText().toString();
        String text = editTextText.getText().toString();

        if (date.trim().isEmpty() || text.trim().isEmpty()){
            Toast.makeText(this, "Entrer toutes les donnees", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference perturbRef = FirebaseFirestore.getInstance()
                .collection("Mood");
        perturbRef.add(new Mood(mood,date,text));
        Toast.makeText(this, "Sauvegarder", Toast.LENGTH_SHORT).show();
        finish();

    }
}
