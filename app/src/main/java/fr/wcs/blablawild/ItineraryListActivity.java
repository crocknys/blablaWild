package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import org.w3c.dom.Text;

import static fr.wcs.blablawild.ItinerarySearchActivity.*;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intent = getIntent();
        String destination_final = intent.getStringExtra(clefTwo);

        String departure_final = intent.getStringExtra(clefOne);

        setTitle( departure_final + " >>> " + destination_final);
    }

}
