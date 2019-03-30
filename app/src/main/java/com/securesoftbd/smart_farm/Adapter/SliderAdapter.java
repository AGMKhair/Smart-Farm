package com.securesoftbd.smart_farm.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.securesoftbd.smart_farm.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context  = context;
    }

    public int[] slide_images =
            {
                    R.drawable.smart_farm_icon,
                    R.drawable.power_supply_solor,
                    R.drawable.humadity_icon,
                    R.drawable.temperature_icon,
                    R.drawable.water_supplay_icon,
                    R.drawable.power_water_icon,
                    R.drawable.weather_responsive_icon,
                    R.drawable.sms_send_icon,
                    R.drawable.cloud_icon,
                    R.drawable.data_analysis,
                    R.drawable.machine_learning_icon,

            };

    public String[] slide_headings =
            {
                    "IOT Smart Farm",
                    "Power Supply Solor",
                    "Humidity & Other",
                    "Temperature Measure",
                    "Water Supply",
                    "Power Generate",
                    "Weather Responsive",
                    "Data Send",
                    "Cloud Grap",
                    "Data Analysis",
                    "Machine Learning"
            };

    public String[] slide_descs =
            {
                    "This system can control the all particular device",
                    "This system power supply using solar",
                    "It can measure your Humidity, Water-level, moisture and toxic gas",
                    "It can measure your temperature",
                    "It can Auto water supply sensing water sensor",
                    "Portable Nano-Hydro Power Generator from water for more power generate.",
                    "Weather responsive fan light controlled environment",
                    "It can Sends data via mobile SMS && mobile apps",
                    "It can save your body condition in cloud",
                    "It can Get data in CVS, XML and JSON format and send data for matlab analysis",
                    "Predict and further analysis with machine learning in future"
            };







    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.imageId);
        TextView slideHeading = view.findViewById(R.id.headingId);
        TextView slideDescription = view.findViewById(R.id.detailsId);
try {


    slideImageView.setImageResource(slide_images[position]);
    slideHeading.setText(slide_headings[position]);
    slideDescription.setText(slide_descs[position]);

    container.addView(view);
}catch (Exception e)
{

}
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //  super.destroyItem(container, position, object);
        container.removeView((RelativeLayout) object);
    }
}