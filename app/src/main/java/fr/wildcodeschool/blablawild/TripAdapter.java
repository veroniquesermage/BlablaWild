package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
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
        TextView textFirstName = (TextView) convertView.findViewById(R.id.firstName);
        TextView textLastName = (TextView) convertView.findViewById(R.id.lastName);
        TextView textPrice = (TextView) convertView.findViewById(R.id.price);
        TextView textDate = (TextView) convertView.findViewById(R.id.dateTime);

        // Populate the data into the template view using the data object
        textFirstName.setText(trip.getFirstName());
        textLastName.setText(trip.getLastName());
        textDate.setText(trip.getDate());
        String priceStr = String.valueOf(trip.getPrice());
        textPrice.setText(priceStr);

        // Return the completed view to render on screen
        return convertView;
    }
}
