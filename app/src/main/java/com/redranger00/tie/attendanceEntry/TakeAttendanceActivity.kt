package com.redranger00.tie.attendanceEntry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redranger00.tie.databinding.ActivityTakeAttendanceBinding

class TakeAttendanceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTakeAttendanceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTakeAttendanceBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }
}