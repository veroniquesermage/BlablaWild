package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class ItinerarySearchActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Intent intentLast = getIntent();
    }


        public void sendSearch (View view){
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


    }




