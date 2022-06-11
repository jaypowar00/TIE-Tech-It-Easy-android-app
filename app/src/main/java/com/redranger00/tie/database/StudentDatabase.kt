package com.redranger00.tie.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentData::class, Student::class], version = 2, exportSchema = false)
abstract class StudentDatabase: RoomDatabase() {

    abstract val studentDatabaseDao: StudentDatabaseDao

    companion object {
        private var INSTANCE: StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "studentData_table"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}