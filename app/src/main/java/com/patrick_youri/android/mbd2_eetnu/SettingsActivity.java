package com.patrick_youri.android.mbd2_eetnu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_settings);

        Intent intent = getIntent();
        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
