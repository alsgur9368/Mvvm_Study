package com.example.mvvm_example.view

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.mvvm_example.databinding.UserDialogBinding
import com.example.mvvm_example.model.UserEntity
import com.example.mvvm_example.viewModel.ViewModel
import kotlinx.android.synthetic.main.user_dialog.*
import java.util.*

class UserDialog(mContext: Context) : Dialog(mContext) {
    private val model : ViewModel = ViewModel(mContext.applicationContext as Application)

    private lateinit var  mBinding: UserDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = UserDialogBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(window)?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 버튼 리스너 설정
        button_save.setOnClickListener {
            // '확인' 버튼 클릭시 data insert
            model.insert(
                UserEntity(user_name.text.toString(),
                user_gender.text.toString(),user_birth.text.toString())
            )
            // Custom Dialog 종료
            dismiss()
        }
        button_cancel.setOnClickListener {
            // '취소' 버튼 클릭시
            // Custom Dialog 종료
            dismiss()
        }

    }

}