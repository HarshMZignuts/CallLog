package com.example.calllog.fragment.calling

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallingViewModel(finalcall : String) : ViewModel() {

    val _fcall = MutableLiveData<String>()
    val fcall : LiveData<String>
    get() = _fcall

    init{
        _fcall.value = finalcall
        Log.i("ScoreViewModel", "Final score is $finalcall")
    }
}