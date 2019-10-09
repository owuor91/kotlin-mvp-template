package io.owuor91.presentation.di

import dagger.Module
import io.owuor91.data.di.DataModule

@Module(includes = [DataModule::class])
class PresenterModule
