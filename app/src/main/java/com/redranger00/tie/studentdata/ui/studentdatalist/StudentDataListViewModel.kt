package com.redranger00.tie.studentdata.ui.studentdatalist

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.redranger00.tie.database.ListWithStudents
import com.redranger00.tie.database.StudentData
import com.redranger00.tie.database.StudentDatabaseDao
import kotlinx.coroutines.launch

class StudentDataListViewModel(
    dataSource: StudentDatabaseDao, application: Application
) : AndroidViewModel(application) {
    val database = dataSource
    private val studentDataList = MutableLiveData<List<ListWithStudents>?>()
    val studentDataLists = database.getAllLists()

    init {
        initializeStudentList()
    }

    private fun initializeStudentList() {
        viewModelScope.launch {
//            studentDataList.value = getStudentListFromDatabase()
            createOneStudentProfile()
        }
    }

    private suspend fun createOneStudentProfile() {
        val studentList = database.getAllLists().value
        if(studentList == null) {
            val profile = StudentData(profileName = "profile 1")
            database.createStudentList(profile)
            Toast.makeText(this.getApplication(), "created demo list", Toast.LENGTH_LONG).show()
        }

    }

    private fun getStudentListFromDatabase(): List<ListWithStudents>? {
        var studentlist = database.getAllListsWithStudents()
        if(studentlist!!.isEmpty()) {
            studentlist = null
        }
        return studentlist
    }
}