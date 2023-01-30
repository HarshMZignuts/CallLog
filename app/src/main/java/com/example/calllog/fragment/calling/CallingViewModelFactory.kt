package com.example.calllog.fragment.calling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

public class CallingViewModelFactory( val finalnumber : String) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CallingViewModel::class.java)){
            return CallingViewModel(finalnumber) as T
        }
       throw IllegalArgumentException("Unknown View Model")
    }


}