package com.securesoftbd.smart_farm;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.securesoftbd.smart_farm.Adapter.SliderAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button add,profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    init();
    onClick();

    }

    private void onClick() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddProfileActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });
    }

    private void init()
    {
        add = findViewById(R.id.addBtnId);
        profile = findViewById(R.id.profileBtnId);

        viewPager = findViewById(R.id.viewPage);
        mDotLayout = findViewById(R.id.linearLayout);
        // Theme_one = findViewById(R.id.singInBTNId);
        // Theme_two = findViewById(R.id.singUpBTNId);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
    }


    public void addDotsIndicator(int postion)
    {
        // mDots =null;
        mDots = new TextView[11];
        mDotLayout.removeAllViews();
        for(int i = 0 ; i<mDots.length ; i++)
        {
            mDots[i]  = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length >0)
        {
            mDots[postion].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i)
        {

        }
    };

}
