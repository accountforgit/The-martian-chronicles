package the_martian_chronicles.android.the_martian_chronicles.dagger2.modules;

import javax.annotation.Nonnull;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.scopes.FragmentScope;
import the_martian_chronicles.android.the_martian_chronicles.services.WeatherApi;

/**
 * Created by win_user on 05/04/2018.
 */

@Module
public class WeatherModule {
    @Provides
    @FragmentScope
    @Nonnull
    WeatherApi provideApi(Retrofit retrofit){
        return retrofit.create(WeatherApi.class);
    }
}
