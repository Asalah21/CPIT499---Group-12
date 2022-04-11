package com.ASL.HANDY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int images[]={
    R.drawable.firstonboarding,
    R.drawable.secondonborading
    };

int headlines[]={
        R.string.headline1,
        R.string.headline2
};

int discription[]={
        R.string.description1,
        R.string.description2


    };


public ViewPagerAdapter(Context context){
    this.context=context;

}
    @Override
    public int getCount() {
        return headlines.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view= layoutInflater.inflate(R.layout.slider_layout,container,false);
        ImageView slidetitlimage=(ImageView) view.findViewById(R.id.titleimage);
        TextView slideheadings=(TextView) view.findViewById(R.id.texttitle);
        TextView slidediscreption = (TextView) view.findViewById(R.id.description);

        slidetitlimage.setImageResource(images[position]);
        slideheadings.setText(headlines[position]);
        slidediscreption.setText(discription[position]);
        container.addView(view);
        return view;



    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    container.removeView((LinearLayout)object);

    }
}
