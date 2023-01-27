package com.example.calllog.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calllog.model.Call

@Database(entities = [Call::class], version = 1, exportSchema = false)
abstract class CallDataBase :RoomDatabase() {
    abstract fun callDao(): CallDao

    companion object{
        @Volatile
        private var INSTANCE : CallDataBase? = null
        fun getDatabase(context: Context): CallDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CallDataBase::class.java,
                    "call_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }
    }
}