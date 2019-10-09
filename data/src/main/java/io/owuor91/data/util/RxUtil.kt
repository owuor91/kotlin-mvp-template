package io.owuor91.data.util

import io.reactivex.disposables.CompositeDisposable

class RxUtil {
  companion object {
    fun initDisposables(compositeDisposable: CompositeDisposable?): CompositeDisposable {
      return if (compositeDisposable == null || compositeDisposable.isDisposed) {
        CompositeDisposable()
      } else compositeDisposable
      
    }
    
    fun dispose(compositeDisposable: CompositeDisposable?) {
      compositeDisposable?.dispose()
    }
  }
}
