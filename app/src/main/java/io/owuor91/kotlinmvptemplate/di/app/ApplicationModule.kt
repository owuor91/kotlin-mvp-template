package io.owuor91.kotlinmvptemplate.di.app

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import dagger.Module
import dagger.Provides
import io.owuor91.domain.di.DIConstants
import io.owuor91.kotlinmvptemplate.MyApplication
import io.owuor91.kotlinmvptemplate.di.activity.ActivityComponent
import javax.inject.Named

@Module(includes = [AndroidModule::class], subcomponents = [ActivityComponent::class])
class ApplicationModule(private val myApplication: MyApplication) {

  @Provides @Named(DIConstants.APP) fun provideAppContext(): Context {
    return myApplication
  }
  
  @Provides fun provideGson(): Gson {
    return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
  }
}
