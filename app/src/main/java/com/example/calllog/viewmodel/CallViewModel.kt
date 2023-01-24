package com.example.calllog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calllog.data.CallDataBase
import com.example.calllog.model.Call
import com.example.calllog.repository.CallRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CallViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData : LiveData<List<Call>>
    private val repository : CallRepository
    private val callDao = CallDataBase.getDatabase(application).callDao()
    init {
        repository = CallRepository(callDao)
        readAllData = repository.readAllAdata
    }
    fun addCall(call : Call)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCall(call)
        }
    }
}