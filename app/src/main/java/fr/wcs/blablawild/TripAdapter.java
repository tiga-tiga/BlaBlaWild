package fr.wcs.blablawild;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Date;


/**
 * Created by wilder on 05/03/18.
 */

public class TripAdapter extends ArrayAdapter<TripModel> {

    //Constructeur
    public TripAdapter(Context context, ArrayList<TripModel> TripModel)
    {
        super(context, 0, TripModel);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView date = (TextView) convertView.findViewById(R.id.textView_date);
        TextView firstname = (TextView) convertView.findViewById(R.id.textView_firstname);
        TextView lastname = (TextView) convertView.findViewById(R.id.textView_lastname);
        TextView price = (TextView) convertView.findViewById(R.id.textView_price);
        // Populate the data into the template view using the data object

        firstname.setText(trip.getFirstname());
        lastname.setText(trip.getLastname());
        String prices = String.valueOf(trip.getPrice() + "$");
        price.setText(prices);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        String date_format = sdf.format(trip.getDate());
        String dates = date_format +" PM";
        date.setText(dates);
        // Return the completed view to render on screen
        return convertView;
    }
}
