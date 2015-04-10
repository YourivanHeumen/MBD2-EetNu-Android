package com.patrick_youri.android.mbd2_eetnu;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        Button callButton = (Button)getView().findViewById(R.id.callbutton);
        callButton.setOnClickListener(new CallButtonOnClickListener(venue));
    }

    public class CallButtonOnClickListener implements View.OnClickListener {
        private Venue venue;

        public CallButtonOnClickListener(Venue venue) {
            this.venue = venue;
        }

        @Override public void onClick(View v) {
            if (venue.getTelephone() != null) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + venue.getTelephone()));
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Toast.makeText(getActivity(), "Call failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "Call failed, venue have no phonenumber", Toast.LENGTH_SHORT).show();
            }
        }

    }

}