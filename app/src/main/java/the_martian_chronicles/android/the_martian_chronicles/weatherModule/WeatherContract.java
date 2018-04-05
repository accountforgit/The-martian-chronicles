package the_martian_chronicles.android.the_martian_chronicles.weatherModule;

import the_martian_chronicles.android.the_martian_chronicles.models.OpenWeather;
import the_martian_chronicles.android.the_martian_chronicles.services.WeatherApi;

/**
 * Created by win_user on 05/04/2018.
 */

public interface WeatherContract {
    public interface Presenter {
        void loadData(WeatherApi api);
        void setView(WeatherContract.View view);
        void onDestroy();
    }
    public interface View {
        void loading();
        void stopLoading();
        void showError();
        void showWeather(OpenWeather openWeather);
    }
}
