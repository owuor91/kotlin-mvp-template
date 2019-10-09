package io.owuor91.kotlinmvptemplate.di.app

import dagger.Component
import io.owuor91.kotlinmvptemplate.MyApplication
import io.owuor91.kotlinmvptemplate.di.activity.ActivityComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
  fun activityComponentBuilder(): ActivityComponent.Builder

  fun inject(myApplication: MyApplication)
}
