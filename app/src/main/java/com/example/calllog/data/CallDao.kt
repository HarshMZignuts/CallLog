package com.example.calllog.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.calllog.model.Call

@Dao
interface CallDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCall(call: Call)

    @Query("SELECT * FROM call_table Order By id Desc")
    fun readAllData() : LiveData<List<Call>>
}