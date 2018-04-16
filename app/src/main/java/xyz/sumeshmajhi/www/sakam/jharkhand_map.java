package xyz.sumeshmajhi.www.sakam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class jharkhand_map extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    //    LOCATION SERVICE
    private LocationManager mLocationManager;
    private LocationListener mLocationListener;

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


    private GoogleMap mMap;
    private Marker mKathautiya;
    private Marker mLather;
    private Marker mMsgeeta;
    private Marker mSahibganj1;
    private Marker mSanghiri;

    private Marker mDunka;
    private Marker mSahibganj2;
    private Marker mSahraj;
    private Marker mSalgadhi;
    private Marker mTorsinduri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_jharkhand_map );

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById( R.id.map );
        mapFragment.getMapAsync( this );

        mLocationManager = (LocationManager) this.getSystemService( LOCATION_SERVICE );
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d( "Location : ", location.toString() );
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        if (Build.VERSION.SDK_INT < 23) {
            if (ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mLocationManager.requestLocationUpdates( LocationManager
                    .GPS_PROVIDER, 0, 0, mLocationListener );
        } else {

            if (ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

                ActivityCompat.requestPermissions( this, new String[]{Manifest.permission
                        .ACCESS_FINE_LOCATION}, 1 );
                return;
            } else {
                mLocationManager.requestLocationUpdates( LocationManager
                        .GPS_PROVIDER, 0, 0, mLocationListener );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED) {

            }
        }

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
        public void onMapReady (GoogleMap googleMap){
            mMap = googleMap;

            //CHANGE MAP TYPE
            mMap.setMapType( GoogleMap.MAP_TYPE_NORMAL );

            //JHARKHAND MAP TYPE
            List<Marker> markerList = new ArrayList<>();

            //EMRS
            mKathautiya = mMap.addMarker( new MarkerOptions().position( KATHAUTIYA )
                    .title( "Upg.P.S.Buiyan Toli,Kathautiya School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mKathautiya.setTag( 0 );
            markerList.add( mKathautiya );

            mLather = mMap.addMarker( new MarkerOptions().position( LATHER )
                    .title( "Govt Ms Ashram Latehar School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_RED ) ) );
            mLather.setTag( 0 );
            markerList.add( mLather );

            mMsgeeta = mMap.addMarker( new MarkerOptions().position( MSGEETA )
                    .title( "M.S.Geeta Ashram School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mMsgeeta.setTag( 0 );
            markerList.add( mMsgeeta );

            mSahibganj1 = mMap.addMarker( new MarkerOptions().position( SAHIBGANJ1 )
                    .title( "Upg Ps. Ashram, Sarkari Gali School" ).snippet( "Kuch V" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_RED ) ) );
            mSahibganj1.setTag( 0 );
            markerList.add( mSahibganj1 );

            mSanghiri = mMap.addMarker( new MarkerOptions().position( SANGHIRI )
                    .title( "Upg.M.S.Hindi Sanghri School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mSanghiri.setTag( 0 );
            markerList.add( mSanghiri );

            //ASHRAM
            mDunka = mMap.addMarker( new MarkerOptions().position( DUMKA )
                    .title( "Eklavya Model Res Girl'S School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mDunka.setTag( 0 );
            markerList.add( mDunka );

            mSahibganj2 = mMap.addMarker( new MarkerOptions().position( SAHIBGANJ2 )
                    .title( "Sk Eklavya Vidhyalaya Bhognadih School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mSahibganj2.setTag( 0 );
            markerList.add( mSahibganj2 );

            mSahraj = mMap.addMarker( new MarkerOptions().position( SAHRAJ )
                    .title( "Eklavya Madhyamik Vidyalaya Sahraj School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mSahraj.setTag( 0 );
            markerList.add( mSahraj );

            mSalgadhi = mMap.addMarker( new MarkerOptions().position( SALGADHI )
                    .title( "-: Eklavya Vidyalaya Salgadih School" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mSalgadhi.setTag( 0 );
            markerList.add( mSalgadhi );

            mTorsinduri = mMap.addMarker( new MarkerOptions().position( TORSINDURI )
                    .title( "Torsinduri, Pashchimi Singhbhum, Jharkhand, Postal Code: 833201 India" )
                    .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) ) );
            mTorsinduri.setTag( 0 );
            markerList.add( mTorsinduri );

            mMap.setOnMarkerClickListener( this );

            for (Marker m : markerList) {
                LatLng latLng = new LatLng( m.getPosition().latitude, m.getPosition().longitude );
                //mMap.addMarker(new MarkerOptions().position(latLng));
                mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( latLng, 15 ) );
                mMap.animateCamera( CameraUpdateFactory.newLatLngZoom( latLng, 5 ) );
            }


        }

        @Override
        public boolean onMarkerClick (Marker marker){
            Integer clickCount = (Integer) marker.getTag();
            if (clickCount != null) {
                clickCount = clickCount + 1;

                marker.setTag( clickCount );
                Toast.makeText( this, marker.getTitle() + "has been clicked" + clickCount + "times", Toast.LENGTH_LONG ).show();

            }
            return false;
        }
}

