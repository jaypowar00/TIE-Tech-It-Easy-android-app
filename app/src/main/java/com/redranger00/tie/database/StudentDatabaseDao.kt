package com.redranger00.tie.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDatabaseDao {
    @Insert
    suspend fun createStudentList(studentdata: StudentData)

    @Insert
    suspend fun addStudentToList(student: Student)

    @Update
    suspend fun updateStudentListName(studentdata: StudentData)

    @Update
    suspend fun updateStudentInfo(student: Student)

    @Query("SELECT * FROM studentData_table WHERE listId = :key")
    fun getList(key: Long): ListWithStudents

    @Query("SELECT * FROM studentData_table")
    fun getAllLists(): LiveData<List<StudentData>?>

    @Query("SELECT * FROM studentData_table ORDER BY listId DESC")
    fun getAllListsWithStudents(): List<ListWithStudents>?

    @Query("DELETE FROM studentData_table WHERE listId = :key")
    suspend fun deleteList(key: Long)
}