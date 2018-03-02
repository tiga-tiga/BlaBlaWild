package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        final Intent intent = new Intent(this, ItineraryListActivity.class);

        Button searchListener = findViewById(R.id.buttonSearch);
        searchListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText departure = findViewById(R.id.editTextDeparture);
                EditText destination = findViewById(R.id.editTextDestination);
                String testDeparture = departure.getText().toString();
                String testDestination = destination.getText().toString();

                if(testDeparture.length() == 0 || testDestination.length() == 0)
                {
                    Toast.makeText(ItinerarySearchActivity.this, "Please field Departure AND Destination", Toast.LENGTH_SHORT).show();
                }
                else
                {


                    intent.putExtra("depeartureTitle", testDeparture);
                    intent.putExtra("destinationTitle", testDestination);
                    startActivity(intent);


                }

            }
        });



    }

}
