package fr.wcs.blablawild;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wilder on 06/03/18.
 */

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        TripModel trip = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }

        TextView prenom = convertView.findViewById(R.id.viewPrenom);
        TextView nom= convertView.findViewById(R.id.viewNom);
        TextView prix = convertView.findViewById(R.id.viewPrix);
        TextView date = convertView.findViewById(R.id.viewDate);

        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyy-hh:mm");
        String newDate = sdf.format(trip.getDate());

        String prixFinal = String.valueOf(trip.getPrix());

        prenom.setText(trip.getPrenom());
        nom.setText(trip.getNom());
        prix.setText("$" + prixFinal);
        date.setText(newDate + "PM");

        return convertView;
    }
}
