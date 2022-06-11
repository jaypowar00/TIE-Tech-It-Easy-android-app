package com.redranger00.tie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import com.redranger00.tie.attendanceEntry.TakeAttendanceActivity
import com.redranger00.tie.databinding.ActivityMainBinding
import com.redranger00.tie.studentdata.StudentDataActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        val takeAttendanceBtn = binding.takeAttendanceBtn
        val studentDataBtn = binding.studentDataBtn

        takeAttendanceBtn.setOnClickListener {
            val intent = Intent(this, TakeAttendanceActivity::class.java)
            startActivity(intent)
        }

        takeAttendanceBtn.setOnLongClickListener {

            val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
            true
        }

        studentDataBtn.setOnClickListener {
            val intent = Intent(this, StudentDataActivity::class.java)
            startActivity(intent)
        }


        setSupportActionBar(binding.toolbar)

        setContentView(view)
    }
}