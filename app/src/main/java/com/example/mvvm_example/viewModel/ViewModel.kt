package com.example.mvvm_example.viewModel

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModel( application: Application) : AndroidViewModel(application){
    var main_text: ObservableField<String> = ObservableField("Main")
    val mApplication = application

    fun onClickButton(){
        // TODO: Click 시 Room에 데이터를 추가해야 함.
        Toast.makeText(mApplication,"Click!",Toast.LENGTH_SHORT).show()
    }

}