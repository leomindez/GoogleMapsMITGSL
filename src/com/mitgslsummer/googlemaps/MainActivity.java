package com.mitgslsummer.googlemaps;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements LocationListener {

	private GoogleMap googleMap1, googleMap2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		googleMap1 = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_map1)).getMap();

		googleMap2 = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_map2)).getMap();

		// googleMap2.setMyLocationEnabled(true);
		addMarker(googleMap1, new LatLng(19.324994, -99.1856), "C.U",
				BitmapDescriptorFactory.HUE_BLUE);

		addMarker(googleMap2, new LatLng(19.324994, -99.1820), "C.U",
				BitmapDescriptorFactory.HUE_GREEN);

	}

	private void addMarker(GoogleMap googleMap, LatLng latLng, String title,
			float color) {
		
		
		
		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions.describeContents();
		markerOptions.position(latLng);
		markerOptions.title(title);
		markerOptions.icon(BitmapDescriptorFactory.defaultMarker(color));
		googleMap.addMarker(markerOptions);

		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));

	}

	@Override
	public void onLocationChanged(Location location) {

	}

}
