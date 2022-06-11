package com.redranger00.tie.attendanceEntry.ui.attendanceEntry

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redranger00.tie.database.StudentDatabaseDao
import java.lang.IllegalArgumentException

class AttendanceDetailFormViewModelFactory(
    private val dataSource: StudentDatabaseDao, private val application: Application
): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AttendanceDetailFormViewModel::class.java)) {
            return AttendanceDetailFormViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}