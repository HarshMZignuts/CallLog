package com.example.calllog.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calllog.R
import com.example.calllog.databinding.FragmentListBinding
import com.example.calllog.viewmodel.CallViewModel


class ListFragment : Fragment() {

    private lateinit var mcallViewModel : CallViewModel
    lateinit var binding: FragmentListBinding
    val adpter = ListAdpter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(LayoutInflater.from(context))
        val view =  binding.root
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adpter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mcallViewModel = ViewModelProvider(this).get(CallViewModel::class.java)
        mcallViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            call->
            adpter.setData(call)
        })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_callFragment)
        }

       // return inflater.inflate(R.layout.fragment_list, container, false)
        return view
    }

}