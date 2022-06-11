package com.redranger00.tie.attendanceEntry.ui.attendanceEntry

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.redranger00.tie.R
import com.redranger00.tie.database.StudentDatabase
import com.redranger00.tie.databinding.AttendanceDetailFormFragmentBinding

class AttendanceDetailForm : Fragment() {

    private lateinit var viewModel: AttendanceDetailFormViewModel
    private lateinit var binding: AttendanceDetailFormFragmentBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AttendanceDetailFormFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application
        val dataSource = StudentDatabase.getInstance(application).studentDatabaseDao
        val viewModelFactory = AttendanceDetailFormViewModelFactory(dataSource, application)
        val attendanceViewModel = ViewModelProvider(this, viewModelFactory).get(
            AttendanceDetailFormViewModel::class.java)

        binding.lifecycleOwner = this
        binding.attendanceViewModel = attendanceViewModel

        return inflater.inflate(R.layout.attendance_detail_form_fragment, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AttendanceDetailFormViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}