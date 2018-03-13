package fr.wcs.blablawild;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wilder on 12/03/18.
 */

public class Carpage extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpage);

        Spinner spinner = (Spinner) findViewById(R.id.spinnertype);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        final Button send = findViewById(R.id.button);
        final TextView km = findViewById(R.id.killometer);
        final TextView hour = findViewById(R.id.hours);
        final TextView brand = findViewById(R.id.brand);
        final TextView model = findViewById(R.id.model);
        final  TextView speed = findViewById(R.id.speed);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    send.setEnabled(false);
                    hour.setVisibility(view.GONE);
                    km.setVisibility(view.GONE);
                    speed.setVisibility(view.GONE);
                }

                if (position == 1) {
                    km.setVisibility(view.VISIBLE);
                    hour.setVisibility(view.GONE);
                    speed.setVisibility(view.GONE);
                    send.setEnabled(true);
                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String fbrand = brand.getText().toString();
                            String fmodel = model.getText().toString();
                            String fkmm = km.getText().toString();


                            if ((fbrand.length() < 1) || (fmodel.length() < 1) || (fkmm.length() < 1)) {
                                Toast.makeText(Carpage.this, R.string.errormessage, Toast.LENGTH_SHORT).show();
                            } else {
                                int fkm = Integer.parseInt(fkmm);
                                VehicleCar voiture = new VehicleCar(fbrand, fmodel, fkm);
                                Toast.makeText(Carpage.this, voiture.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                if (position == 2) {
                    hour.setVisibility(view.VISIBLE);
                    km.setVisibility(view.GONE);
                    speed.setVisibility(view.GONE);
                    send.setEnabled(true);
                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String fbrand = brand.getText().toString();
                            String fmodel = model.getText().toString();
                            String houur = hour.getText().toString();

                            if ((houur.length() < 1) || (fmodel.length() < 1) || (fbrand.length() < 1)) {
                                Toast.makeText(Carpage.this, R.string.errormessage, Toast.LENGTH_SHORT).show();
                            } else {
                                int fhouur = Integer.parseInt(houur);
                                VehicleBoat bateau = new VehicleBoat(fbrand, fmodel, fhouur);
                                Toast.makeText(Carpage.this, bateau.getDescription(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

                if (position == 3) {
                    speed.setVisibility(view.VISIBLE);
                    hour.setVisibility(view.GONE);
                    km.setVisibility(view.GONE);
                    send.setEnabled(true);
                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String fbrand = brand.getText().toString();
                            String fmodel = model.getText().toString();
                            String speeed = speed.getText().toString();

                            if ( (speeed.length() < 1) || (fmodel.length() < 1) || (fbrand.length() < 1) ) {
                                Toast.makeText(Carpage.this, R.string.errormessage, Toast.LENGTH_SHORT).show();
                            } else {
                                int fspeed = Integer.parseInt(speeed);
                                VehiclePlane plane = new VehiclePlane(fbrand, fmodel, fspeed);
                                Toast.makeText(Carpage.this, plane.getDescription(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

}
