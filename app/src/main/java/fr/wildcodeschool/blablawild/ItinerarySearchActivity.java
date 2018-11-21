package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ItinerarySearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Intent intentLast = getIntent();

        final Calendar myCalendar = Calendar.getInstance();
        final EditText dateText = (EditText) findViewById(R.id.date);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, dateText);

            }
        };
        dateText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    public void sendSearch(View view) {
        // Do something in response to button
        final EditText desTxt = findViewById(R.id.editText2);
        final Button button = findViewById(R.id.button);
        final EditText depTxt = findViewById(R.id.editText);

        Context context = getApplicationContext();

        String lText = depTxt.getText().toString();
        String fText = desTxt.getText().toString();


        if (lText.matches("") || fText.matches("")) {
            CharSequence textError = getString(R.string.error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, textError, duration);
            toast.show();

            toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 0);

        } else {

            Intent intentSearch = new Intent(this, ItineraryListActivity.class);

            EditText editText = (EditText) findViewById(R.id.editText);
            EditText editText2 = (EditText) findViewById(R.id.editText2);
            String message = editText.getText().toString() + " >> " + editText2.getText().toString();
            intentSearch.putExtra(getString(R.string.extrames), message);

            startActivity(intentSearch);
        }
    }

    private void updateLabel(Calendar myCalendar, EditText dateText) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateText.setText(sdf.format(myCalendar.getTime()));
    }
}
