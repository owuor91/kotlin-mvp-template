package io.owuor91.kotlinmvptemplate

import android.app.Application

import com.facebook.stetho.Stetho
import io.owuor91.kotlinmvptemplate.di.activity.ActivityComponent
import io.owuor91.kotlinmvptemplate.di.activity.ActivityModule
import io.owuor91.kotlinmvptemplate.di.app.AndroidModule
import io.owuor91.kotlinmvptemplate.di.app.ApplicationComponent
import io.owuor91.kotlinmvptemplate.di.app.ApplicationModule
import io.owuor91.kotlinmvptemplate.di.app.DaggerApplicationComponent
import io.owuor91.kotlinmvptemplate.ui.activities.BaseActivity
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MyApplication : Application() {
  private var applicationComponent: ApplicationComponent? = null

  override fun onCreate() {
    super.onCreate()
    applicationComponent = DaggerApplicationComponent.builder()
      .applicationModule(ApplicationModule(this))
      .androidModule(AndroidModule(this))
      .build()
    applicationComponent!!.inject(this)

    Stetho.initializeWithDefaults(this)

    /*CalligraphyConfig.initDefault(
      CalligraphyConfig.Builder().setDefaultFontPath(CUSTOM_FONT_ASSET_PATH)
        .setFontAttrId(R.attr.fontPath)
        .build()
    )*/

  }

  fun getActivityInjector(baseActivity: BaseActivity): ActivityComponent {
    return applicationComponent!!.activityComponentBuilder().activityModule(ActivityModule(baseActivity)).build()
  }

  companion object {
    val CUSTOM_FONT_ASSET_PATH = "fonts/GothamRoundedBook.ttf"
  }
}
