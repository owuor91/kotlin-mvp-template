package io.owuor91.kotlinmvptemplate

import android.os.Bundle
import android.widget.Toast
import io.owuor91.domain.model.Note
import io.owuor91.kotlinmvptemplate.ui.activities.BaseActivity
import io.owuor91.presentation.NotesPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), NotesPresenter.View {
  @Inject lateinit var notesPresenter: NotesPresenter
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injector().inject(this)
    setContentView(R.layout.activity_main)
  }
  
  override fun onStart() {
    super.onStart()
    notesPresenter.view = this
    notesPresenter.getNotes()
  }
  
  override fun displayNotes(notesList: List<Note>) {
    
    Toast.makeText(baseContext,notesList.size.toString(), Toast.LENGTH_LONG).show()
  }
}
