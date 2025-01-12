package com.example.pam_pert11.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pam_pert11.MahasiswaApp
import com.example.pam_pert11.ui.home.viewmodel.HomeViewModel
import com.example.pam_pert11.ui.insert.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        // home view model
        initializer {
            HomeViewModel(
                mahasiswaApp().container.repositoryMhs
            )
        }

        // insert view model
        initializer {
            InsertViewModel(
                mahasiswaApp().container.repositoryMhs
            )
        }
    }
}

fun CreationExtras.mahasiswaApp(): MahasiswaApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApp)