package com.example.calllog.fragment.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    val tv_number_list = MutableLiveData<String>()
    val tv_time_list = MutableLiveData<String>()
}