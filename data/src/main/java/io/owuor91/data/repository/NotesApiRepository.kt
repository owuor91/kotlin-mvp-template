package io.owuor91.data.repository

import io.owuor91.data.api.NotesApi
import io.owuor91.domain.model.Note
import io.owuor91.domain.repository.NotesRepository
import io.reactivex.Single

class NotesApiRepository : NotesRepository {
  var notesApi: NotesApi;
  
  constructor(notesApi: NotesApi) {
    this.notesApi = notesApi
  }
  
  override fun getNotes(): Single<List<Note>> {
    return notesApi.getNotes();
  }
}