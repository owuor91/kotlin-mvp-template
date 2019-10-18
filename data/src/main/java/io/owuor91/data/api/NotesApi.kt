package io.owuor91.data.api

import io.owuor91.domain.model.Note
import io.reactivex.Single

interface NotesApi {
  fun getNotes() : Single<List<Note>>
}