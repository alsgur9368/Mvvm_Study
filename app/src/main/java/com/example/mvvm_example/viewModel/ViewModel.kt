package com.example.mvvm_example.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_example.AppDatabase
import com.example.mvvm_example.model.Repository
import com.example.mvvm_example.model.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel( application: Application) : AndroidViewModel(application){
    var main_text: ObservableField<String> = ObservableField("Main")
    val repository: Repository =  Repository(AppDatabase.getDatabase(application,viewModelScope))
    var allUsers: LiveData<List<UserEntity>> = repository.allUsers


    fun insert(userEntity: UserEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(userEntity)
    }

}