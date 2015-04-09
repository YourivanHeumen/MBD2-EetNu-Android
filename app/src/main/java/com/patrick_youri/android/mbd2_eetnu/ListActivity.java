package com.patrick_youri.android.mbd2_eetnu;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_settings was selected
            case R.id.action_settings:
                Intent intent = new Intent(getApplicationContext(),
                        SettingsActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }

        return true;
    }
}

