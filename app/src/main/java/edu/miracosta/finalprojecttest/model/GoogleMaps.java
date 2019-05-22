package edu.miracosta.finalprojecttest.model;

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
import edu.miracosta.finalprojecttest.model.GoogleMapsInformation.DBHelper;
import edu.miracosta.finalprojecttest.model.GoogleMapsInformation.Location;
import edu.miracosta.finalprojecttest.model.GoogleMapsInformation.LocationListAdapter;


//TODO: (1) Implement the OnMapReadCallback interface for Google Maps
//TODO: First, you'll need to compile GoogleMaps in build.gradle
//TODO: and add permissions and your Google Maps API key in the AndroidManifest.xml


public class GoogleMaps extends AppCompatActivity implements OnMapReadyCallback {

    private DBHelper db;
    private List<Location> allLocationsList;
    private ListView locationsListView;
    private LocationListAdapter locationListAdapter;

    //member variable to store google map
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_maps);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importLocationsFromCSV("locations.csv");

        allLocationsList = db.getAllCaffeineLocations();


        //TODO: (2) Load the support map fragment asynchronously
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

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

        //add all the caffeine locations to the map
        //Loop through list and add each location
        LatLng position;
        for(Location location : allLocationsList)
        {
            position = new LatLng(location.getLatitude(), location.getLongitude());
            map.addMarker(new MarkerOptions().position(position).title(location.getName()));
        }
    }
    public void viewLocationsDetails(View v)
    {

    }

    // TODO: (3) Implement the onMapReady method, which will add a special "marker" for our current location,
    // TODO: which is  33.190802, -117.301805  (OC4800 building)
    // TODO: Then add normal markers for all the caffeine locations from the allLocationsList.
    // TODO: Set the zoom level of the map to 15.0f


    // TODO: (4) Create a viewLocationsDetails(View v) method to create a new Intent to the
    // TODO: CaffeineDetailsActivity class, sending it the selectedLocation the user picked from the locationsListView
}
