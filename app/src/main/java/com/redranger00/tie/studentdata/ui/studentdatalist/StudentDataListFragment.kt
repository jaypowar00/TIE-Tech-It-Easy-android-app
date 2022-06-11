package com.redranger00.tie.studentdata.ui.studentdatalist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.redranger00.tie.R
import com.redranger00.tie.attendanceEntry.ui.attendanceEntry.AttendanceDetailFormViewModel
import com.redranger00.tie.attendanceEntry.ui.attendanceEntry.AttendanceDetailFormViewModelFactory
import com.redranger00.tie.database.StudentDatabase
import com.redranger00.tie.databinding.StudentDataListFragmentBinding
import com.redranger00.tie.studentdata.adapter.StudentDataListAdapter

class StudentDataListFragment : Fragment() {

    private lateinit var studentDataListViewModel: StudentDataListViewModel
    private lateinit var binding: StudentDataListFragmentBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        binding = StudentDataListFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application
        val dataSource = StudentDatabase.getInstance(application).studentDatabaseDao
        val viewModelFactory = StudentDataListViewModelFactory(dataSource, application)
        studentDataListViewModel = ViewModelProvider(this, viewModelFactory)
            .get(StudentDataListViewModel::class.java)

        binding.studentViewModel = studentDataListViewModel
        val adapter = StudentDataListAdapter()
        binding.rvStudentDataList.adapter = adapter

        studentDataListViewModel.studentDataLists.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.lifecycleOwner = this.parentFragment
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(StudentDataListViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}