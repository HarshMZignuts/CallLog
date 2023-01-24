package com.example.calllog.repository

import androidx.lifecycle.LiveData
import com.example.calllog.data.CallDao
import com.example.calllog.model.Call

class CallRepository(private val callDao : CallDao) {
    val readAllAdata : LiveData<List<Call>> = callDao.readAllData()

    suspend fun addCall(call : Call)
    {
        callDao.addCall(call)
    }
}