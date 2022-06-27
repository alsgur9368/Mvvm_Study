package com.example.mvvm_example.model

import androidx.lifecycle.LiveData
import com.example.mvvm_example.AppDatabase

class Repository(mDatabase: AppDatabase) {

    private val userDao = mDatabase.userDao()
    val allUsers: LiveData<List<UserEntity>> = userDao.getAlphabetizedUsers()

    companion object{
        private var sInstance: Repository? = null
        fun getInstance(database: AppDatabase): Repository {
            return sInstance
                ?: synchronized(this){
                    val instance = Repository(database)
                    sInstance = instance
                    instance
                }
        }
    }

    suspend fun insert(userEntity: UserEntity) {
        userDao.insert(userEntity)
    }
}