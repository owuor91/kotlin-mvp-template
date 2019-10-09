package io.owuor91.kotlinmvptemplate.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.owuor91.data.util.RxUtil
import io.owuor91.kotlinmvptemplate.di.activity.ActivityComponent
import io.owuor91.kotlinmvptemplate.di.fragment.FragmentComponent
import io.owuor91.kotlinmvptemplate.di.fragment.FragmentModule
import io.owuor91.kotlinmvptemplate.ui.activities.BaseActivity
import io.reactivex.disposables.CompositeDisposable

class BaseFragment : Fragment() {

  val layoutId: Int
    get() = NO_LAYOUT
  private lateinit var compositeDisposable: CompositeDisposable

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injector().baseInject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return if (layoutId != NO_LAYOUT) {
//ButterKnife.bind(this, view);
      inflater.inflate(layoutId, container, false)
    } else {
      super.onCreateView(inflater, container, savedInstanceState)
    }
  }

  fun handleError(throwable: Throwable) {
    Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
  }

  protected fun injector(): FragmentComponent {
    return activityInjector().fragmentBuilder().fragmentModule(FragmentModule(this)).build()
  }

  protected fun activityInjector(): ActivityComponent {
    return (activity as BaseActivity).injector()
  }

  override fun onDestroy() {
    super.onDestroy()
    dispose()
  }
  
  protected fun dispose() {
    RxUtil.dispose(compositeDisposable);
  }

  companion object {
    private val NO_LAYOUT = -1
  }
}
