package com.redranger00.tie.studentdata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.redranger00.tie.database.StudentData
import com.redranger00.tie.databinding.StudentDataItemViewBinding

class StudentDataListAdapter: ListAdapter<StudentData, StudentDataListAdapter.ViewHolder>(StudentDataDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: StudentDataItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StudentData){
            binding.studentData = item
            binding.editBtn.setOnClickListener {
                Toast.makeText(itemView.context, "edit clicked", Toast.LENGTH_LONG).show()
            }
            binding.deleteBtn.setOnClickListener {
                Toast.makeText(itemView.context, "delete clicked", Toast.LENGTH_LONG).show()
            }
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = StudentDataItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class StudentDataDiffCallback: DiffUtil.ItemCallback<StudentData>() {
        override fun areItemsTheSame(oldItem: StudentData, newItem: StudentData): Boolean {
            return oldItem.listId == newItem.listId
        }

        override fun areContentsTheSame(oldItem: StudentData, newItem: StudentData): Boolean {
            return oldItem == newItem
        }
    }

}