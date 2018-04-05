package the_martian_chronicles.android.the_martian_chronicles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import the_martian_chronicles.android.the_martian_chronicles.weatherModule.WeatherFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        if(getSupportFragmentManager().findFragmentByTag("weather")==null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content,new WeatherFragment(),"weather")
                    .commit();
        }
    }
}
