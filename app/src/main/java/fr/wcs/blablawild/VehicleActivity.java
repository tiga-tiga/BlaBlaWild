package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                String selection = selectVehicle.getItemAtPosition(position).toString();

                //choix car
                if (selection.matches("Car")) {

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
                             int kmDescription = Integer.valueOf(kmdesc);
                            VehicleCar car = new VehicleCar(brandDescription,modelDescription,kmDescription);
                            Toast.makeText(VehicleActivity.this, car.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                //choix boat
                if (selection.matches("Boat")){
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
                            int hDescription = Integer.valueOf(hdesc);
                            VehicleBoat boat = new VehicleBoat(brandDescription,modelDescription,hDescription);
                            Toast.makeText(VehicleActivity.this, boat.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                //choix plane
                if (selection.matches("Plane")){
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
                            int speedDescription = Integer.valueOf(speeddesc);
                            VehiclePlane plane = new VehiclePlane(brandDescription,modelDescription,speedDescription);
                            Toast.makeText(VehicleActivity.this, plane.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                if(selection.matches("Please select..")){
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
