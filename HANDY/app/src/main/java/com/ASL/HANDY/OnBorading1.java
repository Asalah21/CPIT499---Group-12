package com.ASL.HANDY;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBorading1 extends AppCompatActivity {


    ViewPager mSlideViewoPager;
    LinearLayout mLayout;
    Button backbtn, nextbtn, skipbtn;

    TextView[]dots;
    ViewPagerAdapter viewPagerAdapter;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding1);

        getSupportActionBar().hide();

        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);
        skipbtn = findViewById(R.id.skipbtn);



        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(getitem(0)>0){
     mSlideViewoPager.setCurrentItem(getitem(-1),true);
}


            }


        });


   nextbtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if (getitem(0)<1)
               mSlideViewoPager.setCurrentItem(getitem(1),true);


               else{
                       Intent i = new Intent(OnBorading1.this,LandingPage.class);
                       startActivity(i);
                       finish();
               }



       }
   });
skipbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent i = new Intent(OnBorading1.this,LandingPage.class);
        startActivity(i);
        finish();

    }
});

mSlideViewoPager =(ViewPager) findViewById(R.id.slideViewPage);
mLayout = (LinearLayout) findViewById(R.id.page_indicator);
        viewPagerAdapter = new ViewPagerAdapter(this);

mSlideViewoPager.setAdapter(viewPagerAdapter);
        pinindicator(0);
        mSlideViewoPager.addOnPageChangeListener(viewlistner);
        }

@RequiresApi(api = Build.VERSION_CODES.M)
public void  pinindicator(int position){
        dots= new TextView[2];

    mLayout.removeAllViews();
    for(int i = 0 ; i <dots.length; i++){
        dots[i]= new TextView(this);
        dots[i].setText(Html.fromHtml("&#8226"));
        dots[i].setTextSize(35);
        dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
        mLayout.addView(dots[i]);


    }
dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }
    ViewPager.OnPageChangeListener viewlistner= new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onPageSelected(int position) {
pinindicator(position);
if(position>0){
    backbtn.setVisibility(View.VISIBLE);

}else{
    backbtn.setVisibility(View.INVISIBLE);

}
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
private int getitem(int i ){
    return mSlideViewoPager.getCurrentItem()+i;


}


    }
