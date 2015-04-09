package com.patrick_youri.android.mbd2_eetnu;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.patrick_youri.android.mbd2_eetnu.models.Venue;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Need to check if Activity has been switched to landscape mode
        // If yes, finished and go back to the start Activity
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        setContentView(R.layout.activity_detail);

        Venue venue = (Venue)getIntent().getSerializableExtra(ListActivity.SER_KEY);
        if(venue != null) {
            DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                    .findFragmentById(R.id.detailFragment);
            if(detailFragment != null) {
                detailFragment.setVenue(venue);
            }
        }

    }
}