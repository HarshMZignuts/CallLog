package com.example.calllog.fragment.calling

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.calllog.R

import com.example.calllog.databinding.FragmentCallingBinding
import com.example.calllog.model.Call

import com.example.calllog.viewmodel.CallViewModel



@Suppress("DEPRECATION")
class CallingFragment : Fragment() {
   //private lateinit var  viewModel : CallingViewModel
    //private lateinit var mcallViewModel : CallViewModel

    private lateinit var viewModelFactory: CallingViewModelFactory
    private val args by navArgs<CallingFragmentArgs>()
    private val viewModel : CallingViewModel by viewModels{viewModelFactory}
    private val mcallViewModel : CallViewModel by viewModels()







    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {




        val binding: FragmentCallingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_calling,
            container,
            false
        )
        viewModelFactory = CallingViewModelFactory(CallingFragmentArgs.fromBundle(requireArguments()).dialnumber)

        //viewModel = ViewModelProvider(this,viewModelFactory)[CallingViewModel::class.java]


        binding.callingViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //this is for add data in databse
        //mcallViewModel = ViewModelProvider(this)[CallViewModel::class.java]


        binding.tvTimer.start()

        binding.callEndFloatingBtn.setOnClickListener {
            binding.tvTimer.stop()
//            Log.d("afefaf",binding.tvTimer.text.toString())
            val call  = Call(0,viewModel.fcall.value.toString(),binding.tvTimer.text.toString())
            viewModel.calended.value = "CallEnded"
            Handler().postDelayed({
                findNavController().navigate(R.id.action_callingFragment_to_listFragment)
            },2000)
            mcallViewModel.addCall(call)


        }


        return binding.root
    }





}