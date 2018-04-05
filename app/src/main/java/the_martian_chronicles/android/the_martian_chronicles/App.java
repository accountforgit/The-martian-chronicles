package the_martian_chronicles.android.the_martian_chronicles;

import android.app.Application;

import the_martian_chronicles.android.the_martian_chronicles.dagger2.components.AppComponent;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.components.WeatherComponent;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.modules.AppModule;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.modules.WeatherModule;

/**
 * Created by win_user on 05/04/2018.
 */

public class App extends Application{

    private static App app;
    private AppComponent appComponent;
    private WeatherComponent weatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(app))
                .build();
    }

    public static App getApp(){
        return app;
    }

    public WeatherComponent plusWeatherComponent(){
        if(weatherComponent==null)
            weatherComponent=appComponent.plus(new WeatherModule());
        return weatherComponent;
    }

    public void destroyWeatherComponent(){
        weatherComponent=null;
    }
}
