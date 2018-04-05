package the_martian_chronicles.android.the_martian_chronicles.weatherModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import the_martian_chronicles.android.the_martian_chronicles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment  implements WeatherContract.View{



    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

}
