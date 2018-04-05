package the_martian_chronicles.android.the_martian_chronicles.weatherModule;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import the_martian_chronicles.android.the_martian_chronicles.models.OpenWeather;
import the_martian_chronicles.android.the_martian_chronicles.services.WeatherApi;

/**
 * Created by win_user on 05/04/2018.
 */

public class WeatherPresenter implements WeatherContract.Presenter {

    CompositeDisposable disposables = new CompositeDisposable();


    WeatherContract.View view;


    @Override
    public void loadData(WeatherApi api) {
        view.loading();
        disposables.add(api.getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<OpenWeather>(){

                    @Override
                    public void onSuccess(OpenWeather openWeather) {
                        view.stopLoading();
                        view.showWeather(openWeather);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onError: "+e.getMessage());
                        view.stopLoading();
                        view.showError();
                    }
                })
        );
    }

    @Override
    public void setView(WeatherContract.View view) {
        this.view=view;
    }

    @Override
    public void onDestroy() {
        view=null;
        disposables.dispose();
    }

}
