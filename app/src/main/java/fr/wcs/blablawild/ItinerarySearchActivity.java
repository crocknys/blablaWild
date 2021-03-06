package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String clefOne = "premiereclef";
    public static final String clefTwo = "deuxiemeclef";
    Calendar myCalendar = Calendar.getInstance();
    EditText edittext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        edittext = findViewById(R.id.dateText);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    public void search (View view) {

        TextView destinationBox = findViewById(R.id.destinationText);
        TextView departureBox = findViewById(R.id.departureText);

        String destination = destinationBox.getText().toString();
        String departure = departureBox.getText().toString();

        if ((destination.length() < 1 ) || (departure.length() <1 )) {
            Toast.makeText(this, fr.wcs.blablawild.R.string.error, Toast.LENGTH_SHORT).show();
        } else {
            Intent goList = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
            goList.putExtra(clefOne,departure);
            goList.putExtra(clefTwo,destination);
            ItinerarySearchActivity.this.startActivity(goList);
        }
    }

}


