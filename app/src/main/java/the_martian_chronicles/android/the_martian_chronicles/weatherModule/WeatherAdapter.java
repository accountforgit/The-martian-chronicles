package the_martian_chronicles.android.the_martian_chronicles.weatherModule;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import the_martian_chronicles.android.the_martian_chronicles.R;
import the_martian_chronicles.android.the_martian_chronicles.models.Weather;
import the_martian_chronicles.android.the_martian_chronicles.models.WeatherInfo;

/**
 * Created by win_user on 05/04/2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    private final List<WeatherInfo> weatherInfos;

    private final String weeks[]=new String[]{"","MON","TUE","WED","THU","FRI","SUN","SAT"};


    public WeatherAdapter(List<WeatherInfo> weatherInfos){
        this.weatherInfos = weatherInfos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date(weatherInfos.get(position).getDt()*1000));
        Weather weather = weatherInfos.get(position).getMain();
        holder.time.setText(String.format("%s %s",
                weeks[calendar.get(Calendar.DAY_OF_WEEK)],
                weatherInfos.get(position).getDtTxt().substring(11, 16)));
        holder.date.setText(weatherInfos.get(position).getDtTxt().substring(0,10));
        holder.pressure.setText(String.format("%s",
                weather.getPressure()+"hPa"));
        holder.min_temp.setText(String.format("%s",
                weather.getTempMin().intValue()+"\u2103"));
        holder.max_temp.setText(String.format("%s",
                weather.getTempMax().intValue()+"\u2103"));
    }

    @Override
    public int getItemCount() {
        return weatherInfos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.date_value)
        TextView date;
        @BindView(R.id.pressure_value)
        TextView pressure;
        @BindView(R.id.max_temp)
        TextView max_temp;
        @BindView(R.id.min_temp)
        TextView min_temp;
        @BindView(R.id.time_value)
        TextView time;

        View main_view;

        public MyViewHolder(View view) {
            super(view);
            main_view=view;
            ButterKnife.bind(this,view);
        }
    }
}