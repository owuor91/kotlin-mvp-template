package io.owuor91.presentation

interface BasePresenter {
  fun dispose()
  
  interface View{
    fun handleError(throwable: Throwable)
  }
}