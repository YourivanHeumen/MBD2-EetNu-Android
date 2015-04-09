package com.patrick_youri.android.mbd2_eetnu;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.getDefaultSharedPreferences();

        //link met waar in onderanderen heb geprobeert te zoeken hoe deze shit werkt
        // http://www.cs.dartmouth.edu/~campbell/cs65/lecture12/lecture12.html

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings_preference);
    }
}
