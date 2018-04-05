package the_martian_chronicles.android.the_martian_chronicles.dagger2.scopes;

/**
 * Created by win_user on 05/04/2018.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}