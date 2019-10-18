package io.owuor91.data.di

import dagger.Module
import dagger.Provides
import io.owuor91.data.api.NotesApi
import io.owuor91.data.repository.NotesApiRepository
import io.owuor91.domain.di.DIConstants
import io.owuor91.domain.repository.NotesRepository
import javax.inject.Named

@Module
class RepositoryModule {
  @Provides @Named(DIConstants.API) fun provideNotesApiRepository(notesApi: NotesApi):
      NotesRepository {
    return NotesApiRepository(notesApi)
  }
}

