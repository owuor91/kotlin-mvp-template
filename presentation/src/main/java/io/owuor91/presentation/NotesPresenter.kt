package io.owuor91.presentation

import io.owuor91.data.repository.NotesApiRepository
import io.owuor91.domain.di.DIConstants
import io.owuor91.domain.model.Note
import io.owuor91.domain.repository.NotesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class NotesPresenter @Inject constructor() : BasePresenter {
  lateinit var compositeDisposable: CompositeDisposable
  lateinit var view: View
  @Inject @Named(DIConstants.API) lateinit var notesApiRepository: NotesRepository
  
  fun getNotes() {
    compositeDisposable = CompositeDisposable()
    
    var disposable = notesApiRepository.getNotes()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(view::displayNotes, view::handleError)
    
    compositeDisposable.add(disposable)
  }
  
  override fun dispose() {
  
  }
  
  public interface View : BasePresenter.View {
    fun displayNotes(notesList: List<Note>)
  }
}