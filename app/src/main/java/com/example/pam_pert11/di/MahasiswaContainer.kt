package com.example.pam_pert11.di

import com.example.pam_pert11.repository.NetworkRepositoryMhs
import com.example.pam_pert11.repository.RepositoryMhs
import com.google.firebase.firestore.FirebaseFirestore


interface AppContainer{
    val repositoryMhs: RepositoryMhs
}

class MahasiswaContainer: AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }

}