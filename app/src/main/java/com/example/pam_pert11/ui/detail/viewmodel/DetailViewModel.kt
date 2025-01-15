package com.example.pam_pert11.ui.detail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_pert11.model.Mahasiswa
import com.example.pam_pert11.repository.RepositoryMhs
import com.example.pam_pert11.ui.insert.viewmodel.MahasiswaEvent
import com.example.pam_pert11.ui.navigation.DestinasiDetail
import kotlinx.coroutines.launch

sealed class DetailUiState {
    data class Success(val mahasiswa: MahasiswaEvent) : DetailUiState()
    data class Error(val errorMessage: String) : DetailUiState()
    object Loading : DetailUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: RepositoryMhs
) : ViewModel() {

    var mahasiswaDetailState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    init {
        getMahasiswabyNim()
    }

    fun getMahasiswabyNim() {
        viewModelScope.launch {
            mahasiswaDetailState = DetailUiState.Loading
            try {
                mhs.getMhs(_nim).collect { result ->
                    mahasiswaDetailState = DetailUiState.Success(result.toDetailUiEvent())
                }
            } catch (e: Exception) {
                mahasiswaDetailState = DetailUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}

fun Mahasiswa.toDetailUiEvent(): MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan,
        judulSkripsi = judulSkripsi,
        dosenPembimbing1 = dosenPembimbing1,
        dosenPembimbing2 = dosenPembimbing2
    )
}

