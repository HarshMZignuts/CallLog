package com.example.calllog.fragment.call


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalViewModel : ViewModel() {
    var digit_on_screen = StringBuilder()



    val tvnumber = MutableLiveData<String>()
    private val _callNumber = MutableLiveData<Boolean>()
    val callNumber : LiveData<Boolean>
    get() = _callNumber


    fun btnNumber(digit: String) {

        appendToDigitOnScreen(digit)
    }

    private fun appendToDigitOnScreen(digit: String) {

        // Add each digit to our string builder
        digit_on_screen.append(digit)

        // display it on the screen of our mobile app
        tvnumber.value = digit_on_screen.toString()
    }

    fun clearDigit() {

        val length = digit_on_screen.length
        if (length == 0) {
//            Toast.makeText(, "Nothing To Remove", Toast.LENGTH_SHORT).show()

        } else {
            digit_on_screen.deleteCharAt(length - 1)
            tvnumber.value = digit_on_screen.toString()
        }



    }
    fun onHoldClear(): Boolean {
        val length = digit_on_screen.length
        if(length == 0){

        }
        else{
            digit_on_screen.delete(0,length)
            tvnumber.value = digit_on_screen.toString()

        }
        return true
    }

}