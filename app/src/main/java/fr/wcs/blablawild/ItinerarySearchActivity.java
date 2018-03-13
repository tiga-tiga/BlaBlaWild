package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {
    //méthode de remplissage du champ de date
    private void updateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        editText.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        final Intent intent = new Intent(this, ItineraryListActivity.class);


        final Calendar myCalendar = Calendar.getInstance();
        final EditText editTextDate= (EditText) findViewById(R.id.editTextDate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editTextDate, myCalendar);
            }

        };
        //affichage du DatePicker au click du champ de text
        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        Button searchListener = findViewById(R.id.buttonSearch);
        searchListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText departure = findViewById(R.id.editTextDeparture);
                EditText destination = findViewById(R.id.editTextDestination);
                EditText date = findViewById(R.id.editTextDate);
                String testDeparture = departure.getText().toString();
                String testDestination = destination.getText().toString();
                String testDate = date.getText().toString();

                if(testDeparture.length() == 0 || testDestination.length() == 0)
                {
                    Toast.makeText(ItinerarySearchActivity.this, "Please field Departure AND Destination", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //parcelable searchModel
                    intent.putExtra("searchModel", new SearchModel(testDeparture,testDestination, testDate));
                    //intent.putExtra("departureTitle", testDeparture);
                    //intent.putExtra("destinationTitle", testDestination);
                    startActivity(intent);


                }

            }
        });



    }

}
