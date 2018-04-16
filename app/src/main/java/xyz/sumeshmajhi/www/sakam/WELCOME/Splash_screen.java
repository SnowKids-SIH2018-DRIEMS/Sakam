package xyz.sumeshmajhi.www.sakam.WELCOME;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import xyz.sumeshmajhi.www.sakam.MainActivity;
import xyz.sumeshmajhi.www.sakam.R;

/**
 * Created by saGen on 30-03-2018.
 */

public class Splash_screen  extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_splash_screen);

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_screen.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
