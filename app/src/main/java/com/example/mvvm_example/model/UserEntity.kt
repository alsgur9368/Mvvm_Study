package com.example.mvvm_example.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name="name")
    val name: String,

    @ColumnInfo(name="gender")
    val gender: String?,

    @ColumnInfo(name="birth")
    val birth: String?
)
