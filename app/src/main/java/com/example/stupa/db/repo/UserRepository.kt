package com.example.stupa.db.repo

import com.example.stupa.db.UserDao
import com.example.stupa.db.entity.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    suspend fun registerUser(user: User, onSuccess: () -> Unit, onFail: (e: Exception) -> Unit) {
        try {
            userDao.insert(user)
            onSuccess.invoke()
        } catch (e: Exception) {
            onFail.invoke(e)
        }
    }

    suspend fun login(email: String, password: String): User? {
        return userDao.getUserByEmailAndPassword(email, password)
    }
}
