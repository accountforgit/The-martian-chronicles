package the_martian_chronicles.android.the_martian_chronicles.services;


/**
 * Created by win_user on 05/04/2018.
 */

import io.reactivex.Single;
import retrofit2.http.GET;

import the_martian_chronicles.android.the_martian_chronicles.models.OpenWeather;

public interface WeatherApi {

    @GET("/data/2.5/forecast")
    Single<OpenWeather> getWeather();


}
