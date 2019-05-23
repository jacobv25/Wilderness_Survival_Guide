package edu.miracosta.finalprojecttest.model;

/**
 * GoogleMaps.java: Used in the GoogleMaps activity,
 * this class displays the location of where the program was built, being MiraCosta College!
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */

import android.os.Bundle;

import android.view.View;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.R;

public class GoogleMaps extends AppCompatActivity implements OnMapReadyCallback {


    //member variable to store google map
    private GoogleMap map;

    /**
     * The method runs when the activity loads, linking the Google Maps Fragment and displays it
     * @param savedInstanceState - A variable containing data that allows the activity to go to
     *                             a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_maps);

        //TODO: (2) Load the support map fragment asynchronously
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    /**
     * Allows Google Maps to be displayed on an activity, and make markers
     * on specific locations. You can also look around with the camera.
     * @param googleMap - Data associated with Google Maps
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        map = googleMap;
        //Specify our location with Latlng class
        LatLng myPosition = new LatLng(33.1909544, -117.3019135);

        //Let's add our position to the map
        map.addMarker(new MarkerOptions().position(myPosition).title("Current Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker)));

        //Move camera to our position
        CameraPosition cameraPosition = new CameraPosition.Builder().target(myPosition).zoom(15.0f).build();

        //Update the position (move to location)
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

        //Instruct map to move to this position
        map.moveCamera(cameraUpdate);

    }
}
