package com.example.calllog.fragment.calling

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.calllog.R
import com.example.calllog.data.CallDataBase
import com.example.calllog.databinding.FragmentCallingBinding
import com.example.calllog.model.Call
import com.example.calllog.repository.CallRepository
import com.example.calllog.viewmodel.CallViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


class CallingFragment : Fragment() {
    lateinit var viewModel: CallingViewModel
    lateinit var mcallViewModel : CallViewModel
    lateinit var viewModelFactory: CallingViewModelFactory





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        val binding: FragmentCallingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_calling,
            container,
            false
        )
        viewModelFactory = CallingViewModelFactory(CallingFragmentArgs.fromBundle(requireArguments()).dialnumber)
        viewModel = ViewModelProvider(this,viewModelFactory).get(CallingViewModel::class.java)

        binding.callingViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //this is for add data in databse
        mcallViewModel = ViewModelProvider(this).get(CallViewModel::class.java)


        binding.tvTimer.start()

        binding.callEndFloatingBtn.setOnClickListener {
            binding.tvTimer.stop()
//            Log.d("afefaf",binding.tvTimer.text.toString())
            var call = Call(0,viewModel.fcall.value.toString(),binding.tvTimer.text.toString())

            Handler().postDelayed({
                findNavController().navigate(R.id.action_callingFragment_to_listFragment)
            },2000)
            mcallViewModel.addCall(call)


        }


        return binding.root
    }





}