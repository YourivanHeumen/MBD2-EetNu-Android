package com.patrick_youri.android.mbd2_eetnu.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Youri on 7-4-2015.
 */
public abstract class JSONParser {

    public static String getJSON(URL url) throws IOException {
        StringBuilder response = new StringBuilder();

        HttpURLConnection httpconn = (HttpURLConnection)url.openConnection();
        int code = httpconn.getResponseCode();
        if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK)
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()),8192);
            String strLine = null;
            while((strLine = input.readLine()) != null)
            {
                response.append(strLine);
            }
            input.close();
        }
        return response.toString();
    }

    public static ArrayList<Venue> parseJSONResponse(String json){
        ArrayList<Venue> venues = new ArrayList<Venue>();

        try {
            JSONArray jsonArray = new JSONObject(json).getJSONArray("results");

            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonVenueObject = jsonArray.getJSONObject(i);

                int id = jsonVenueObject.getInt("id");
                String name = jsonVenueObject.getString("name");
                String category = jsonVenueObject.getString("category");
                String website_url = jsonVenueObject.getString("website_url");
                String telephone = jsonVenueObject.getString("telephone");
                double distance = jsonVenueObject.getDouble("distance");

                JSONObject jsonAddressObject = jsonVenueObject.getJSONObject("address");
                String street = jsonAddressObject.getString("street");
                String zipcode = jsonAddressObject.getString("zipcode");
                String city = jsonAddressObject.getString("city");
                String region = jsonAddressObject.getString("region");
                String country = jsonAddressObject.getString("country");

                JSONObject jsonGeolocationObject = jsonVenueObject.getJSONObject("geolocation");
                double latitude = jsonGeolocationObject.getDouble("latitude");
                double longitude = jsonGeolocationObject.getDouble("longitude");

                Venue venue = new Venue(id, name, category, website_url, telephone,
                        new Address(street, zipcode, city, region, country),
                        new Geolocation(latitude, longitude), distance);

                venues.add(venue);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return venues;
    }
}
