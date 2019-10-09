package io.owuor91.kotlinmvptemplate.ui.activities

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.owuor91.data.util.RxUtil
import io.owuor91.kotlinmvptemplate.MyApplication
import io.owuor91.kotlinmvptemplate.di.activity.ActivityComponent
import io.reactivex.disposables.CompositeDisposable
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class BaseActivity : AppCompatActivity() {
  protected lateinit var compositeDisposable: CompositeDisposable
  
  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)
    injector().baseInject(this)
  }
  
  fun injector(): ActivityComponent {
    return (applicationContext as MyApplication).getActivityInjector(this)
  }
  
  fun handleError(throwable: Throwable) {
    Toast.makeText(baseContext, throwable.message, Toast.LENGTH_LONG).show()
  }
  
  override fun onStart() {
    super.onStart()
    compositeDisposable = RxUtil.initDisposables(compositeDisposable)
  }
  
  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
  }
  
  protected fun dispose() {
    RxUtil.dispose(compositeDisposable)
  }
}