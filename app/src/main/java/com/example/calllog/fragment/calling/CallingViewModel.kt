package com.example.calllog.fragment.calling

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.icu.text.UnicodeSetSpanner.CountMethod
import android.os.CountDownTimer
import android.os.IBinder
import android.os.SystemClock
import android.provider.CallLog
import android.text.Editable.Factory
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.calllog.data.CallDataBase
import com.example.calllog.model.Call
import com.example.calllog.repository.CallRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.Provider.Service
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject


public class CallingViewModel(finalcall : String
) : ViewModel() {

    val _fcall = MutableLiveData<String>()
    val calended = MutableLiveData<String>()
    val fcall : LiveData<String>
    get() = _fcall


    init{
        _fcall.value = finalcall

    }
    companion object {


    }
}



