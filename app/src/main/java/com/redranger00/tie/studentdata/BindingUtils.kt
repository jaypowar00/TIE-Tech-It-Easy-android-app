package com.redranger00.tie.studentdata

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.redranger00.tie.database.StudentData

@BindingAdapter("studentDataProfileName")
fun TextView.setStudentDataProfileName(item: StudentData) {
    text = item.profileName
}