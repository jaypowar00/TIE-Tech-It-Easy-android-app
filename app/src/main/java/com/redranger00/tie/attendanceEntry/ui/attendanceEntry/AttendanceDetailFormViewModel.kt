package com.redranger00.tie.attendanceEntry.ui.attendanceEntry

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.redranger00.tie.database.StudentData
import com.redranger00.tie.database.StudentDatabaseDao

class AttendanceDetailFormViewModel(
    database: StudentDatabaseDao, application: Application
) : AndroidViewModel(application) {
    private val attendance = MutableLiveData<StudentData?>()

}