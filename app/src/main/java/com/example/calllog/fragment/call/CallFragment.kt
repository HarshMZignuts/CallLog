package com.example.calllog.fragment.call


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.findNavController
import com.example.calllog.R
import com.example.calllog.databinding.FragmentCallBinding



class CallFragment : Fragment() {

    private lateinit var binding: FragmentCallBinding

    private val viewModel : CalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_call,
            container,
            false
        )

        binding.calViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        binding.callFloatingBtn.setOnClickListener {
            if(TextUtils.isEmpty(viewModel.tvnumber.value))
            {
                Toast.makeText(context,"Enter Number First",Toast.LENGTH_SHORT).show()
            }
            else {
                val action =
                    CallFragmentDirections.actionCallFragmentToCallingFragment(viewModel.tvnumber.value.toString())
                findNavController().navigate(action)
            }
        }



        return binding.root
    }






    }






