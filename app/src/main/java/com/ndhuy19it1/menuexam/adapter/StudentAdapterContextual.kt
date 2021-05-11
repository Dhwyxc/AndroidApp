package com.ndhuy19it1.menuexam.adapter

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ndhuy19it1.menuexam.R
import com.ndhuy19it1.menuexam.databinding.ActivityMainBinding.inflate
import com.ndhuy19it1.menuexam.model.Student

class StudentAdapterContextual(val students : List<Student>) : RecyclerView.Adapter<StudentAdapterContextual.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.std_name_textView)
        val id = itemView.findViewById<TextView>(R.id.std_id_textView)

        fun bind(student: Student){
            name.text = student.name
            id.text = student.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_row_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int {
        return students.size
    }
}