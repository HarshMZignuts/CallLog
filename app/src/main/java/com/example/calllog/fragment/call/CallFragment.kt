package com.example.calllog.fragment.call

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.calllog.R
import com.example.calllog.databinding.FragmentCallBinding



class CallFragment : Fragment() {

    lateinit var binding: FragmentCallBinding
//    var digit_on_screen = StringBuilder()
    lateinit var viewModel : CalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(CalViewModel::class.java)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_call,
            container,
            false
        )

        binding.calViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

//        binding.callFloatingBtn.setOnClickListener {
//            findNavController().navigate(R.id.action_callFragment_to_callingFragment)
//        }
        //initializeButtons()
//        number()
//        binding.callFloatingBtn.setOnClickListener {
//            findNavController().navigate(R.id.action_callFragment_to_callingFragment)
//        }
        binding.callFloatingBtn.setOnClickListener {
            var action = CallFragmentDirections.actionCallFragmentToCallingFragment(viewModel.tvnumber.value.toString())
            findNavController().navigate(action)
        }
//        viewModel.callNumber.observe(
//            viewLifecycleOwner, Observer<Boolean>{
//                called->
//                if (called) callDialed()
//            }
//
//        )


        return binding.root
    }


//    fun callDialed(){
//        val action = CallFragmentDirections.actionCallFragmentToCallingFragment(viewModel.tvnumber.value.toString())
//
//        NavHostFragment.findNavController(this).navigate(action)
//        viewModel.floatintCall()




    }
//    private fun number(){
//        binding.tvDialYourNumber.text = viewModel.tvnumber.value.toString()
//    }


//    fun numberEvent(view: View) {
//        var bucclick : String = binding.tvDialYourNumber.text.toString()
//        var buselect : Button = view as Button
//        when(buselect)
//        {
//            binding.btn0 -> {bucclick += "0"}
//            binding.btn1 -> {bucclick += "1"}
//            binding.btn2 -> {bucclick += "2"}
//            binding.btn3 -> {bucclick += "3"}
//            binding.btn4 -> {bucclick += "4"}
//            binding.btn5 -> {bucclick += "5"}
//            binding.btn6-> {bucclick += "6"}
//            binding.btn7 -> {bucclick += "7"}
//            binding.btn8 -> {bucclick += "8"}
//            binding.btn9 -> {bucclick += "9"}
//            binding.btnHas -> {bucclick += "#"}
//            binding.btnStar -> {bucclick += "*"}
//
//
//        }
//        binding.tvDialYourNumber.text = bucclick
//    }

//    private fun initializeButtons() {
//        numericalButton()
//        functionalButtons()
//    }

//    private fun numericalButton() {
//        binding.btn0.setOnClickListener {
//            appendToDigitOnScreen("0")
//        }
//        binding.btn1.setOnClickListener {
//            appendToDigitOnScreen("1")
//        }
//        binding.btn2.setOnClickListener {
//            appendToDigitOnScreen("2")
//        }
//        binding.btn3.setOnClickListener {
//            appendToDigitOnScreen("3")
//        }
//        binding.btn4.setOnClickListener {
//            appendToDigitOnScreen("4")
//        }
//        binding.btn5.setOnClickListener {
//            appendToDigitOnScreen("5")
//        }
//        binding.btn6.setOnClickListener {
//            appendToDigitOnScreen("6")
//        }
//        binding.btn7.setOnClickListener {
//            appendToDigitOnScreen("7")
//        }
//        binding.btn8.setOnClickListener {
//            appendToDigitOnScreen("8")
//        }
//        binding.btn9.setOnClickListener {
//            appendToDigitOnScreen("9")
//        }
//        binding.btnHas.setOnClickListener {
//            appendToDigitOnScreen("#")
//        }
//        binding.btnStar.setOnClickListener {
//            appendToDigitOnScreen("*")
//        }
//
//
//    }

//    private fun appendToDigitOnScreen(digit: String) {
//
//        // Add each digit to our string builder
//        digit_on_screen.append(digit)
//
//        // display it on the screen of our mobile app
//        binding.tvDialYourNumber.text = digit_on_screen.toString()
//    }

//    private fun functionalButtons() {
//        binding.btnBackSlash.setOnClickListener {
//            clearDigit()
//        }
//        binding.btnVideo.setOnClickListener {
//            Toast.makeText(context, "Video Call Currently Unable", Toast.LENGTH_SHORT).show()
//        }
//        binding.callFloatingBtn.setOnClickListener {
//            val bundle = Bundle()
//            var callingFragment = CallingFragment()
//            bundle.putString("number",binding.tvDialYourNumber.text.toString())
//            callingFragment.arguments = bundle
//
//            findNavController().navigate(R.id.action_callFragment_to_callingFragment)
//        }
//
//    }

//    private fun clearDigit() {
//
//        val length = digit_on_screen.length
//        if (length == 0) {
//            Toast.makeText(context, "Nothing To Remove", Toast.LENGTH_SHORT).show()
//        } else {
//            digit_on_screen.deleteCharAt(length - 1)
//            binding.tvDialYourNumber.text = digit_on_screen.toString()
//        }
//
//
//    }



