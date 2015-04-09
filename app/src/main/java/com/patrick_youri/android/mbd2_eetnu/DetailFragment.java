package com.patrick_youri.android.mbd2_eetnu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.patrick_youri.android.mbd2_eetnu.models.Venue;

public class DetailFragment extends Fragment {

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_venue_detail,
                container, false);
        return view;
    }

    public void setVenue(Venue venue) {
        TextView detailsName = (TextView) getView().findViewById(R.id.detailsName);
        TextView detailsCity = (TextView) getView().findViewById(R.id.detailsCity);
        TextView detailsStreet = (TextView) getView().findViewById(R.id.detailsStreet);
        TextView detailsPostalcode = (TextView) getView().findViewById(R.id.detailsPostalcode);
        TextView detailsPhone = (TextView) getView().findViewById(R.id.detailsPhone);

        detailsName.setText(venue.getName());
        detailsCity.setText(venue.getAddress().getCity());
        detailsStreet.setText(venue.getAddress().getStreet());
        detailsPostalcode.setText(venue.getAddress().getZipcode());
        detailsPhone.setText(venue.getTelephone());
    }
}