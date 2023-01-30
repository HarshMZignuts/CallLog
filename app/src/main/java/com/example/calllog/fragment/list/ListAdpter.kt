package com.example.calllog.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.calllog.R
import com.example.calllog.databinding.CustomListBinding
import com.example.calllog.diffUtil.MyDiffutil
import com.example.calllog.model.Call


class ListAdpter: RecyclerView.Adapter<ListAdpter.MyViewHolder>(){
    private var callList = emptyList<Call>()


    class MyViewHolder(
        private val binding: CustomListBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(currentItem : Call){
           binding.lviewModel = currentItem
        }
        companion object{
            fun from(parent: ViewGroup):MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CustomListBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       //val currenItem = callList[position]
       val currenItem = callList.getOrNull(position)

        currenItem?.let {
            holder.bind(it)
        }

//        holder.itemView.findViewById<TextView>(R.id.tv_number_list).text = currenItem?.num
//        holder.itemView.findViewById<TextView>(R.id.tv_time_list).text = currenItem?.time
    }

    override fun getItemCount(): Int {
        return callList.size

    }
fun setData(call : List<Call>) {
//    this.callList = call
//    notifyDataSetChanged()
    val diffUtil = MyDiffutil(callList,call)
    val diffResult = DiffUtil.calculateDiff(diffUtil)
    callList = call
    diffResult.dispatchUpdatesTo(this)
}



}