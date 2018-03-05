package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String clefOne = "premiereclef";
    public static final String clefTwo = "deuxiemeclef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
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
