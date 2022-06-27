package com.example.mvvm_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_example.Adpater.UserListAdapter
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

        val mAdapter = UserListAdapter(this)
        mBinding.recyclerview.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
        model.allUsers.observe(this, Observer { user ->
            //Update the cached copy of the user in the adapter
            user?.let { mAdapter.setUsers(it) }
        })
        mBinding.btnAdd.setOnClickListener {
            val dlg = UserDialog(this)
            dlg.show()
        }
    }
}