package the_martian_chronicles.android.the_martian_chronicles.weatherModule;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import the_martian_chronicles.android.the_martian_chronicles.App;
import the_martian_chronicles.android.the_martian_chronicles.DateActivity;
import the_martian_chronicles.android.the_martian_chronicles.R;
import the_martian_chronicles.android.the_martian_chronicles.models.OpenWeather;
import the_martian_chronicles.android.the_martian_chronicles.services.WeatherApi;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment implements WeatherContract.View{

    @Inject
    WeatherApi weatherApi;

    @Inject
    WeatherContract.Presenter weatherPresenter;

    @Inject
    Context context;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    KProgressHUD dialog;


    public WeatherFragment() {
        // Required empty public constructor
        App.getApp().plusWeatherComponent().inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, view);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DateActivity.class));
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        weatherPresenter.setView(this);
        initDialog();
        return view;
    }

    private void initDialog() {
        dialog=KProgressHUD.create(getActivity())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        weatherPresenter.loadData(weatherApi);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        weatherPresenter.onDestroy();
        App.getApp().destroyWeatherComponent();
    }

    @Override
    public void loading() {
        dialog.show();
    }

    @Override
    public void stopLoading() {
        dialog.dismiss();
    }

    @Override
    public void showError() {
        if(getActivity()!=null){
            Toast.makeText(getActivity(), "Network error.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showWeather(OpenWeather openWeather) {
        Log.d("log ", "showWeather: count "+openWeather.getList().size());
        recyclerView.setAdapter(new WeatherAdapter(openWeather.getList()));
    }
}
