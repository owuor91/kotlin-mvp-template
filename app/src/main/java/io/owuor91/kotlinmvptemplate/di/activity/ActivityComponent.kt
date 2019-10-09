package io.owuor91.kotlinmvptemplate.di.activity

import dagger.Subcomponent
import io.owuor91.kotlinmvptemplate.di.adapter.AdapterComponent
import io.owuor91.kotlinmvptemplate.di.fragment.FragmentComponent
import io.owuor91.kotlinmvptemplate.ui.activities.BaseActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
  fun fragmentBuilder(): FragmentComponent.Builder

  fun adapterBuilder(): AdapterComponent.Builder

  fun baseInject(baseActivity: BaseActivity)

  @Subcomponent.Builder
  interface Builder {
    fun activityModule(activityModule: ActivityModule): Builder

    fun build(): ActivityComponent
  }
}
