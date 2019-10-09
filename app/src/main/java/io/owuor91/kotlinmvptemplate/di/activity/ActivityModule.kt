package io.owuor91.kotlinmvptemplate.di.activity

import android.content.Context
import androidx.fragment.app.FragmentManager
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import io.owuor91.domain.di.DIConstants
import io.owuor91.kotlinmvptemplate.di.adapter.AdapterComponent
import io.owuor91.kotlinmvptemplate.ui.activities.BaseActivity
import io.owuor91.presentation.di.PresenterModule
import javax.inject.Named

@Module(includes = [PresenterModule::class], subcomponents = [AdapterComponent::class])
class ActivityModule(private val baseActivity: BaseActivity) {

  @Provides @Named(DIConstants.ACTIVITY) fun provideActivityContext(): Context {
    return baseActivity
  }

  @Provides fun provideActivity(): BaseActivity {
    return baseActivity
  }

  @Provides fun provideLayoutInflater(@Named(DIConstants.ACTIVITY) context: Context): LayoutInflater {
    return LayoutInflater.from(context)
  }

  @Provides fun provideFragmentManager(activity: BaseActivity): androidx.fragment.app.FragmentManager {
    return activity.getSupportFragmentManager()
  }
}
