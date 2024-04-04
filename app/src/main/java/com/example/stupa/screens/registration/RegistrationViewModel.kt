package com.example.stupa.screens.registration

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stupa.db.entity.User
import com.example.stupa.db.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    fun registerUser(user: User, onSuccess: () -> Unit, onFail: (e: Exception) -> Unit) {
        viewModelScope.launch {
            userRepository.registerUser(user, onSuccess, onFail)
        }
    }
}