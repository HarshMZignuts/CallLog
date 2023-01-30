package com.example.calllog.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.calllog.model.Call

class MyDiffutil(
    private val oldList : List<Call>,
    private val newList : List<Call>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
       return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].num != newList[newItemPosition].num -> {
                false
            }
            oldList[oldItemPosition].time != newList[newItemPosition].time -> {
                false
            }
            else -> true
        }
    }
}