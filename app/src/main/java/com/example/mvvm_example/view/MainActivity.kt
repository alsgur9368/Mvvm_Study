package com.example.mvvm_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_example.R
import com.example.mvvm_example.databinding.ActivityMainBinding
import com.example.mvvm_example.viewModel.ViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var  mBinding: ActivityMainBinding
    private val model: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = model
    }
}