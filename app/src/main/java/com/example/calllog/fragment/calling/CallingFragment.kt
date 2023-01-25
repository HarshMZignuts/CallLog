package com.example.calllog.fragment.calling

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.calllog.R
import com.example.calllog.databinding.FragmentCallBinding
import com.example.calllog.databinding.FragmentCallingBinding


class CallingFragment : Fragment() {
    lateinit var viewModel: CallingViewModel
    lateinit var viewModelFactory: CallingViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        binding = FragmentCallingBinding.inflate(LayoutInflater.from(context))
//        var view = binding.root
////        return inflater.inflate(R.layout.fragment_calling, container, false)
//        binding.tvDialedNumber.text = arguments?.getString("number")
        val binding: FragmentCallingBinding= DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_calling,
            container,
            false
        )
        viewModelFactory = CallingViewModelFactory(CallingFragmentArgs.fromBundle(requireArguments()).dialnumber)
        viewModel = ViewModelProvider(this,viewModelFactory).get(CallingViewModel::class.java)
        binding.callingViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }


}