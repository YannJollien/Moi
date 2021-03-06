package com.example.moi.ui.perturb;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moi.R;
import com.example.moi.database.entity.Perturb;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class Activity_Add_Perturb extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDate;
    private EditText editTextText;

    private Button save;
    private Button date;

    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_perturb);

        editTextTitle = findViewById(R.id.add_title);
        editTextDate = findViewById(R.id.add_date);
        editTextText = findViewById(R.id.add_text);

        save = findViewById(R.id.button_save);
        date = findViewById(R.id.date_choser);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.perturb_toolbar);
        setSupportActionBar(myChildToolbar);
        //myChildToolbar.setTitleTextColor(0xFFFFFFFF);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerturb();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Activity_Add_Perturb.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                        editTextDate.setText(mDayOfMonth + ".0" +mMonth+ "." + mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

    }

    private void savePerturb(){
        String title = editTextTitle.getText().toString();
        String date = editTextDate.getText().toString();
        String text = editTextText.getText().toString();
        
        if (title.trim().isEmpty() || date.trim().isEmpty() || text.trim().isEmpty()){
            Toast.makeText(this, "Entrer toutes les donnees", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference perturbRef = FirebaseFirestore.getInstance()
                .collection("Perturbateurs");
        perturbRef.add(new Perturb(title,date,text));
        Toast.makeText(this, "Sauvegarder", Toast.LENGTH_SHORT).show();
        finish();

    }
}
