package com.example.stupa.screens.login

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
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFail: (e: String) -> Unit) {
        viewModelScope.launch {
            val user = userRepository.login(email, password)
            if (user != null) {
                onSuccess()
            } else {
                onFail("Invalid credentials")
            }
        }
    }
}