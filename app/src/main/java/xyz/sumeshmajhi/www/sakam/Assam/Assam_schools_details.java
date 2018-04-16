package xyz.sumeshmajhi.www.sakam.Assam;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.sumeshmajhi.www.sakam.Assam_map;
import xyz.sumeshmajhi.www.sakam.Assam_mapView;
import xyz.sumeshmajhi.www.sakam.Cate.RowData;
import xyz.sumeshmajhi.www.sakam.CurrentLocation;
import xyz.sumeshmajhi.www.sakam.R;
import xyz.sumeshmajhi.www.sakam.fragment.For_Boys;
import xyz.sumeshmajhi.www.sakam.fragment.For_Girls;
import xyz.sumeshmajhi.www.sakam.fragment.State_schools_details;

/**
 * Created by saGen on 30-03-2018.
 */

public class Assam_schools_details extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.assam );

        /* ---floating----*/

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(Assam_schools_details.this,CurrentLocation.class);
              startActivity(intent);
            }
        });


        TextView textView = (TextView) findViewById( R.id.main_toolbar_title );
        Bundle bundle = getIntent().getExtras();
        RowData rowData = (RowData) bundle.getSerializable( "data" );

        textView.setText( rowData.getMain_title() );


        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );


        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById( R.id.view_pager );
        setupViewPager( viewPager );


        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById( R.id.tabs );
        tabs.setupWithViewPager( viewPager );
    }

    // Add Fragments to Tabs

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter( getSupportFragmentManager() );

        adapter.addFragment( new Assam_ashram(), "ASHRAM SCHOOLS" );
        adapter.addFragment( new Assam_eklavya(), "EKALVYA SCHOOLS" );
        viewPager.setAdapter( adapter );
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super( manager );
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get( position );
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add( fragment );
            mFragmentTitleList.add( title );
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get( position );
        }


    }



}