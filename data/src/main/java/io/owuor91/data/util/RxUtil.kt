package io.owuor91.data.util

import io.reactivex.disposables.CompositeDisposable

class RxUtil {
  companion object {
    fun initDisposables(compositeDisposable: CompositeDisposable): CompositeDisposable {
      /*return if (compositeDisposable == null || compositeDisposable.isDisposed) {
        CompositeDisposable()
      } else compositeDisposable*/
      if (compositeDisposable.isDisposed) {
        return CompositeDisposable()
      } else {
        return compositeDisposable
      }
      
    }
    
    fun dispose(compositeDisposable: CompositeDisposable?) {
      compositeDisposable?.dispose()
    }
  }
}
