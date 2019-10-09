package io.owuor91.kotlinmvptemplate.di.fragment

import dagger.Subcomponent
import io.owuor91.kotlinmvptemplate.ui.fragments.BaseFragment

@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

  fun baseInject(baseFragment: BaseFragment)
  @Subcomponent.Builder
  interface Builder {
    fun fragmentModule(fragmentModule: FragmentModule): Builder
    fun build(): FragmentComponent
  }
}
