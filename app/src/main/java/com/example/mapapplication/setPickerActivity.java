package com.example.mapapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class setPickerActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Marker marker;
    private SupportMapFragment supportMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_picker);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng arg0) {
                if (marker != null) {
                    marker.remove();
                }
                MarkerOptions markerOption = new MarkerOptions();
                markerOption.position(arg0).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                marker = mMap.addMarker(markerOption);
                //double mlatitude = arg0.latitude;
                // double mlongitude = arg0.longitude;
                Toast.makeText(getApplicationContext(), "lng : " + arg0.longitude + " lat : " + arg0.latitude, Toast.LENGTH_SHORT).show();

            }
        });

    }
}