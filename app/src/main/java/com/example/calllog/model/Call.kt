package com.example.calllog.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "call_table")
data class Call(
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    val num : String,
    val time : String)