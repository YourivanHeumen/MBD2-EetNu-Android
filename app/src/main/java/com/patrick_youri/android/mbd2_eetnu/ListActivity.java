package com.patrick_youri.android.mbd2_eetnu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.patrick_youri.android.mbd2_eetnu.models.Venue;

public class ListActivity extends Activity implements
        ListFragment.onItemClick {
    public  final static String SER_KEY = "com.patrick_youri.objectPass.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    public void onAdapterItemSelected(Venue venue) {
        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setVenue(venue);
        } else {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putSerializable(SER_KEY, venue);
            intent.putExtras(mBundle);

            startActivity(intent);

        }
    }

}

