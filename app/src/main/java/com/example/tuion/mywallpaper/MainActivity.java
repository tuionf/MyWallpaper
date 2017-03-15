package com.example.tuion.mywallpaper;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private int i = 0;
    private List<View> mViews = new ArrayList<View>();
    private List<Bitmap> bitmaps = new ArrayList<Bitmap>();
    private String[] ss = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        initData();
    }


    /*
     * 添加图片资源  初始化数据
     * */
    private void initData(){

        ss[0] = "https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/Y4P32I1G1K.jpg";
        ss[1] = "http://cn.bing.com/az/hprichbg/rb/EnhancedPinus_ZH-CN11908142325_1920x1080.jpg";
        ss[2] = "http://pic17.nipic.com/20111122/8828408_213400911000_2.jpg";


        for (i = 0; i < ss.length; i++) {

            final ImageView imageView = new ImageView(MainActivity.this);


            SimpleTarget target = new SimpleTarget<Bitmap>(){

                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    imageView.setBackground(new BitmapDrawable(resource));
                    bitmaps.add(resource);

                }
            };

            Glide.with(MainActivity.this).load(ss[i]).asBitmap().into(target);

            mViews.add(imageView);
        }

        ImageAdapter vpAdapter = new ImageAdapter(MainActivity.this,mViews);
        viewPager.setAdapter(vpAdapter);

    }

}