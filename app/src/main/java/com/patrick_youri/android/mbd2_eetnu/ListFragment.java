package com.patrick_youri.android.mbd2_eetnu;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.patrick_youri.android.mbd2_eetnu.adapters.VenuesAdapter;
import com.patrick_youri.android.mbd2_eetnu.models.JSONParser;
import com.patrick_youri.android.mbd2_eetnu.models.Venue;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private OnItemSelectedListener listener;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_venuelist_overview,
                container, false);

        return view;
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;

            LocationManager locationManager = (LocationManager) ((ListActivity)activity).getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, false);
            Location mLocation = locationManager.getLastKnownLocation(provider);

            double lat;
            double lng;
            if (mLocation != null) {
                lat = mLocation.getLatitude();
                lng = mLocation.getLongitude();
            } else {
                lat = 51.6883248;
                lng = 5.2869616;
            }

            new AsyncGetJSON().execute("https://api.eet.nu/venues?max_distance=1.5&geolocation="+lat+","+lng);

        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }

    }

    public void generateList(ArrayList<Venue> venues) {
        listView = (ListView) getActivity().findViewById(R.id.list);
        VenuesAdapter adapter = new VenuesAdapter(getActivity(), R.layout.item_venue, venues);
        listView.setAdapter(adapter);
    }


    // May also be triggered from the Activity
    public void updateDetail() {
        // create fake data
        String newTime = String.valueOf(System.currentTimeMillis());
        // Send data to Activity
        listener.onRssItemSelected(newTime);
    }


    private class AsyncGetJSON extends AsyncTask<String, String, List<Venue>> {

        @Override
        protected List<Venue> doInBackground(String... params) {
            List<Venue> venues;

            try {
                String json = JSONParser.getJSON(new URL(params[0]));
                venues = JSONParser.parseJSONResponse(json);
            } catch (IOException e) {
                e.printStackTrace();
                venues = new ArrayList<Venue>();
            }
            return venues;
        }

        @Override
        protected void onPostExecute(List<Venue> result) {
            generateList((ArrayList<Venue>)result);
        }
    }

}


