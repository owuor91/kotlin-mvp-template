package io.owuor91.data.api

import io.owuor91.domain.model.Note
import io.reactivex.Single
import retrofit2.http.GET

interface NotesApi {
  @GET("api/v1/notes") fun getNotes() : Single<List<Note>>
}