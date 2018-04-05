package the_martian_chronicles.android.the_martian_chronicles.dagger2.components;

import javax.inject.Singleton;

import dagger.Component;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.modules.AppModule;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.modules.WeatherModule;

/**
 * Created by win_user on 05/04/2018.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    WeatherComponent plus(WeatherModule module);
}