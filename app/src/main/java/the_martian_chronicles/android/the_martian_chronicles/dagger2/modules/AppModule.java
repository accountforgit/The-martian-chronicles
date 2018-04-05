package the_martian_chronicles.android.the_martian_chronicles.dagger2.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import the_martian_chronicles.android.the_martian_chronicles.R;

/**
 * Created by win_user on 05/04/2018.
 */


@Module
public class AppModule {

    private Context context;

    public AppModule(@NonNull Context context){
        this.context=context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    OkHttpClient provide(){
        return new OkHttpClient()
                .newBuilder()
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder()
                .serializeNulls()
                .create();
    }


    @Provides
    @Singleton
    @Nonnull
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson,Context context){
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

}