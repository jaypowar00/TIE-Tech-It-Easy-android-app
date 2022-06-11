package com.redranger00.tie.database

import androidx.room.*

@Entity(tableName = "studentData_table")
data class StudentData (
    @PrimaryKey(autoGenerate = true)
    var listId: Long = 0L,
    @ColumnInfo(name = "profileName")
    var profileName: String = "",
)

@Entity(tableName = "student_table",
    foreignKeys = [
        ForeignKey(
            entity = StudentData::class, parentColumns = ["listId"], childColumns = ["ofListId"],
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE
        )
    ])
data class Student (
    @PrimaryKey var stId: Long,
    var RollNo: Long,
    var Name: String,
    var ofListId: Long
)

@Entity
data class ListWithStudents (
    @Embedded val studentData: StudentData,
    @Relation(
        parentColumn = "listId",
        entityColumn = "ofListId"
    )
    val students: List<Student>
)
