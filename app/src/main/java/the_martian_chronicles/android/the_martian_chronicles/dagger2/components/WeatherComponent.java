package the_martian_chronicles.android.the_martian_chronicles.dagger2.components;

import dagger.Subcomponent;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.modules.WeatherModule;
import the_martian_chronicles.android.the_martian_chronicles.dagger2.scopes.FragmentScope;
import the_martian_chronicles.android.the_martian_chronicles.weatherModule.WeatherFragment;

/**
 * Created by win_user on 05/04/2018.
 */

@Subcomponent(modules = {WeatherModule.class})
@FragmentScope
public interface WeatherComponent {

    void inject(WeatherFragment fragment);
}
