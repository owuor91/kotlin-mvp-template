package io.owuor91.domain.repository

import io.owuor91.domain.model.Note
import io.reactivex.Single

interface NotesRepository {
  fun getNotes() : Single<List<Note>>
}