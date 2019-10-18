package io.owuor91.data.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.owuor91.data.BuildConfig
import io.owuor91.data.api.NotesApi
import io.owuor91.domain.di.DIConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class ApiModule {
  
  @Provides @Named(DIConstants.DEFAULT) fun provideDefaultOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
      .writeTimeout(1, TimeUnit.MINUTES)
      .readTimeout(2, TimeUnit.MINUTES)
      .retryOnConnectionFailure(true)
      .build()
  }
  
  @Provides
  @Named(DIConstants.DEFAULT)
  fun provideDefaultRetrofit(gson: Gson, @Named(DIConstants.DEFAULT) okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
      .client(okHttpClient)
      .build()
  }
  
  @Provides @Named(DIConstants.API) fun provideNotesApi(@Named(DIConstants.DEFAULT) retrofit: Retrofit): NotesApi {
    return retrofit.create(NotesApi::class.java)
  }
}
