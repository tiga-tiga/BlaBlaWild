package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        final Spinner selectVehicle = (Spinner) findViewById(R.id.spinnerVehicle);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicleList, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        selectVehicle.setAdapter(adapter);


        // variables that i'll use to the listeners
        final EditText brand = (EditText) findViewById(R.id.editTextBrand);
        final EditText model = (EditText) findViewById(R.id.editTextModel);
        final Button button = (Button) findViewById(R.id.buttonSend);
        final EditText kilometers = (EditText) findViewById(R.id.editTextKilometers);
        final EditText hours = (EditText) findViewById(R.id.editTextHours);
        final EditText speed = (EditText) findViewById(R.id.editTextSpeed);


        selectVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // initialisation des champs
                brand.setText("");
                model.setText("");
                kilometers.setText("");
                hours.setText("");
                speed.setText("");

                //choix car
                if (position == 1) {
                    button.setEnabled(true);
                    kilometers.setVisibility(View.VISIBLE);
                    hours.setVisibility(View.GONE);
                    speed.setVisibility(View.GONE);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             String brandDescription = brand.getText().toString();
                             String modelDescription = model.getText().toString();
                             String kmdesc = kilometers.getText().toString();
                            if(TextUtils.isEmpty(kilometers.getText())) {
                                kmdesc = "0";
                            }
                             int kmDescription = Integer.valueOf(kmdesc);
                            VehicleCar car = new VehicleCar(brandDescription,modelDescription,kmDescription);
                            Toast.makeText(VehicleActivity.this, car.getDescription(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                //choix boat
                if (position == 2){
                    button.setEnabled(true);
                    kilometers.setVisibility(View.GONE);
                    hours.setVisibility(View.VISIBLE);
                    speed.setVisibility(View.GONE);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String brandDescription = brand.getText().toString();
                            String modelDescription = model.getText().toString();
                            String hdesc = hours.getText().toString();
                            if(TextUtils.isEmpty(hours.getText())) {
                                hdesc = "0";
                            }
                            int hDescription = Integer.valueOf(hdesc);
                            VehicleBoat boat = new VehicleBoat(brandDescription,modelDescription,hDescription);
                            Toast.makeText(VehicleActivity.this, boat.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                //choix plane
                if (position == 3){
                    button.setEnabled(true);
                    kilometers.setVisibility(View.GONE);
                    hours.setVisibility(View.GONE);
                    speed.setVisibility(View.VISIBLE);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String brandDescription = brand.getText().toString();
                            String modelDescription = model.getText().toString();
                            String speeddesc = speed.getText().toString();
                            if(TextUtils.isEmpty(speed.getText())) {
                                speeddesc = "0";
                            }
                            int speedDescription = Integer.valueOf(speeddesc);
                            VehiclePlane plane = new VehiclePlane(brandDescription,modelDescription,speedDescription);
                            Toast.makeText(VehicleActivity.this, plane.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                if(position == 0){
                    button.setEnabled(false);
                    kilometers.setVisibility(View.GONE);
                    hours.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
