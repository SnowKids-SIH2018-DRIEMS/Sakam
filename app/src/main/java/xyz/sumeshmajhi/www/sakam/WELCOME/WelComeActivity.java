package xyz.sumeshmajhi.www.sakam.WELCOME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.sumeshmajhi.www.sakam.MainActivity;
import xyz.sumeshmajhi.www.sakam.R;

public class WelComeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout LayoutDots;
    private TextView[] dotsTv;
    private int[]layouts;
    private Button btnskip;
    private Button btnNext;
    private MyPagerAdapter myPagerAdapter;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (!isFirstTimeStartApp()){
          startMainActivity();
          finish();
      }

       setStatusBarTransparent();
      setContentView(R.layout.activity_wel_come);

        viewPager=(ViewPager)findViewById(R.id.view_pager);
        LayoutDots=(LinearLayout)findViewById(R.id.dotLayout);
        btnNext=(Button)findViewById(R.id.btn_next);
        btnskip=(Button)findViewById(R.id.btn_skip);

        //when user press skip ,start  main Activity
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage=viewPager.getCurrentItem()+1;
                if (currentPage<layouts.length){
                    //move to next page
                    viewPager.setCurrentItem(currentPage);
                }else {
                    startMainActivity();
                }


            }
        });

        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startMainActivity();
            }
        });

        layouts=new int[]{R.layout.welcome_slider,R.layout.welcome_slider1,R.layout.welcome_slider2};
        myPagerAdapter=new MyPagerAdapter(layouts,getApplicationContext());
        viewPager.setAdapter(myPagerAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
                public void onPageSelected(int position) {
                if (position==layouts.length-1){
                    btnNext.setText("Start");
                    btnskip.setVisibility( View.GONE);
                }else{
                    btnNext.setText("Next");
                    btnskip.setVisibility( View.VISIBLE);
                }
                setDotStatus(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });
        setDotStatus(0);
    }



    private boolean isFirstTimeStartApp(){
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("introslider", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("FirstTimeStartFlag",true);
    }

    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("introslider", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("FirstTimeStartFlag",stt);
        editor.commit();
    }



    private void setDotStatus(int page){
        LayoutDots.removeAllViews();
        dotsTv=new TextView[layouts.length];
        for (int i = 0; dotsTv.length> i; i++){
            dotsTv[i]=new TextView(this);
            dotsTv[i].setText( Html.fromHtml("&#8226;"));
            dotsTv[i].setTextSize(30);
            dotsTv[i].setTextColor( Color.parseColor("#a9b4bb"));
            LayoutDots.addView(dotsTv[i]);

        }
        //set current dot active
        if(dotsTv.length>0){
            dotsTv[page].setTextColor( Color.parseColor("#ffffff"));
        }
    }

    private void startMainActivity(){
        setFirstTimeStartStatus(true);
        startActivity(new Intent(WelComeActivity.this,MainActivity.class));
        finish();
    }

    private  void setStatusBarTransparent()
    {
        if (Build.VERSION.SDK_INT >=21){
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE| View.SYSTEM_UI_FLAG_FULLSCREEN);

            Window window=getWindow();
            window.addFlags( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor( Color.TRANSPARENT);
        }
    }
}
