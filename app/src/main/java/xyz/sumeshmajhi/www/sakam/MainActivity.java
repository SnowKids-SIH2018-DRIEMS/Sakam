package xyz.sumeshmajhi.www.sakam;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;;



import java.util.Timer;
import java.util.TimerTask;
import me.relex.circleindicator.CircleIndicator;
import xyz.sumeshmajhi.www.sakam.Cate.CategoryActivity;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //TOOLBAR SECTION
    Toolbar toolbar;

    //SLIDESHOW SECTION
    ViewPager viewPager;
    SlideShowAdapter adpter;
    CircleIndicator indicator;
    Handler handler;
    Runnable runnable;
    Timer timer;

    Button emrsButton;
    Button asrmButton;

    //BOTTOM NAVIGATION MENU
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView( R.layout.activity_main );





        /*folding*/
        emrsButton = (Button) findViewById( R.id.emrsButtonID );
        emrsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( MainActivity.this,ERMSYouTube.class );
                startActivity( intent );
            }
        } );

        asrmButton = (Button) findViewById( R.id.asButtonID );
        asrmButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4aHNOkNc1iY") ) );
            }
        } );




        //TOOLBAR SECTION
        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        //SLIDESHOW SECTION
        viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        indicator = (CircleIndicator) findViewById(R.id.circleIndicator_id);

        adpter = new SlideShowAdapter(this);
        viewPager.setAdapter(adpter);
        indicator.setViewPager(viewPager);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                int i = viewPager.getCurrentItem();

                if (i==adpter.images.length-1){

                    i=0;
                    viewPager.setCurrentItem(i,true);

                }else {

                    i++;
                    viewPager.setCurrentItem(i,true);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);
            }
        },4000,4000);

        //BOTTOM NAVIGATION MENU
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }



    //TOOLBAR SECTION
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    //BOTTOM NAVIGATION MENU SECTION
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        Intent in;
        switch (id){

            case R.id.homeAsUp:
                in=new Intent(getBaseContext(),MainActivity.class);
                startActivity(in);
                overridePendingTransition(0, 0);
                break;

            case R.id.bottomListID:
                in=new Intent(getBaseContext(),CategoryActivity.class);
                startActivity(in);
                overridePendingTransition(0, 0);
                break;


            case R.id.bottomFeedbackID:
                in=new Intent(getBaseContext(),DetailsActivity.class);
                startActivity(in);
                overridePendingTransition(0, 0);
                break;

        }
        return false;
    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}
