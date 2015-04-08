package com.patrick_youri.android.mbd2_eetnu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.patrick_youri.android.mbd2_eetnu.R;
import com.patrick_youri.android.mbd2_eetnu.models.Venue;

import java.util.ArrayList;

/**
 * Created by Youri on 8-4-2015.
 */
public class VenuesAdapter extends ArrayAdapter<Venue> {

    public VenuesAdapter(Context context, int resource, ArrayList<Venue> venues) {
        super(context, resource, venues);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Venue venue = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_venue, parent, false);
        }
        // Lookup view for data population
        TextView venueName = (TextView) convertView.findViewById(R.id.venueName);
        // Populate the data into the template view using the data object
        venueName.setText(venue.getName());
        // Return the completed view to render on screen
        return convertView;

    }
}
