package xyz.sumeshmajhi.www.sakam;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Dalobari;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Harihar;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Mukhigaons;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_mongolian;

public class CurrentLocation extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private static final LatLng DALBARI = new LatLng(26.598518, 91.411413);

    private static final LatLng DALOABARI = new LatLng(26.598518, 91.411413);
    private static final LatLng HARIHAR = new LatLng(26.443879, 90.389599);
    private static final LatLng BWISHNOVI = new LatLng(26.390210, 90.076890);
    private static final LatLng MUKHIGAON = new LatLng(26.416963, 90.197846);


    //    ASHRAM SCHOOLS
    private static final LatLng KATHAUTIYA = new LatLng( 24.161770, 85.218133 );
    private static final LatLng LATHER = new LatLng( 23.729547, 84.512757 );
    private static final LatLng MSGEETA = new LatLng( 24.206438, 84.872484 );
    private static final LatLng SAHIBGANJ1 = new LatLng( 25.237318, 87.645128 );
    private static final LatLng SANGHIRI = new LatLng( 24.241579, 84.830413 );

    //    EMRS SCHOOLS
    private static final LatLng DUMKA = new LatLng( 23.875879, 87.196328 );
    private static final LatLng SAHIBGANJ2 = new LatLng( 24.868844, 87.602501 );
    private static final LatLng SAHRAJ = new LatLng( 23.796394, 86.429271 );
    private static final LatLng SALGADHI = new LatLng( 23.083488, 85.641133 );
    private static final LatLng TORSINDURI = new LatLng( 22.658126, 85.820404 );

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    private GoogleMap mMap;
    private Marker mDalbari;

    private Marker mDalobari;
    private Marker mHarihar;
    private Marker mBwishnovi;
    private Marker mMukhigaon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        List<Marker> markerList = new ArrayList<>();


        mDalbari = mMap.addMarker(new MarkerOptions().position(DALBARI)
                .title("DALBARI")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mDalbari.setTag(0);
        markerList.add(mDalbari);

        mDalobari = mMap.addMarker(new MarkerOptions().position(DALOABARI)
                .title("DALOABARI")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mDalobari.setTag(0);
        markerList.add(mDalobari);

        mHarihar = mMap.addMarker(new MarkerOptions().position(HARIHAR)
                .title("HARIHAR")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mHarihar.setTag(0);
        markerList.add(mHarihar);

        mBwishnovi = mMap.addMarker(new MarkerOptions().position(BWISHNOVI)
                .title("BWISHNOVI")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mBwishnovi.setTag(0);
        markerList.add(mBwishnovi);

        mMukhigaon = mMap.addMarker(new MarkerOptions().position(MUKHIGAON)
                .title("MUKHIGAON")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMukhigaon.setTag(0);
        markerList.add(mMukhigaon);





        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        mMap.setOnMyLocationClickListener(onMyLocationClickListener);
        enableMyLocationIfPermitted();

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(1);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("DALBARI")){
                    Intent i = new Intent(CurrentLocation.this, Ashram_Dalobari.class);
                    startActivity(i);
                }else if (marker.getTitle().equals("DALOABARI")){;
                }else if (marker.getTitle().equals("HARIHAR")){
                    Intent i = new Intent(CurrentLocation.this, Ashram_Harihar.class);
                    startActivity(i);
                }else if (marker.getTitle().equals("BWISHNOVI")){
                    Intent i = new Intent(CurrentLocation.this, Ashram_mongolian.class);
                    startActivity(i);
                }else if (marker.getTitle().equals("MUKHIGAON")){
                    Intent i = new Intent(CurrentLocation.this, Ashram_Mukhigaons.class);
                    startActivity(i);
                }
                return true;
            }
        });  // REGISTER OUR CLICK LISTENER

        for (Marker m : markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
//            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        }

    }

    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocationIfPermitted();
                } else {
                    showDefaultLocation();
                }
                return;
            }

        }
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    mMap.setMinZoomPreference(1);
                    return false;
                }
            };

    private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
            new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {

                    mMap.setMinZoomPreference(12);

                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(new LatLng(location.getLatitude(),
                            location.getLongitude()));

                    circleOptions.radius(200);
                    circleOptions.fillColor(Color.RED);
                    circleOptions.strokeWidth(6);

                    mMap.addCircle(circleOptions);
                }
            };

    @Override
    public boolean onMarkerClick(Marker marker) {


        Integer clickCount = (Integer) marker.getTag();
        if (clickCount != null) {
            clickCount = clickCount + 1;

            marker.setTag(clickCount);
            Toast.makeText(this, marker.getTitle() + " has been clicked" + clickCount + "times", Toast
                    .LENGTH_LONG).show();

        }
        return false;


    }
}
