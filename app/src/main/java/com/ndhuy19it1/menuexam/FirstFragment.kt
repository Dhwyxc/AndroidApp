package com.ndhuy19it1.menuexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ndhuy19it1.menuexam.adapter.StudentAdapter
import com.ndhuy19it1.menuexam.data.DataProvider
import com.ndhuy19it1.menuexam.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var studentAdapter: StudentAdapter
    private var binding : FragmentFirstBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(layoutInflater)

        studentAdapter = StudentAdapter(DataProvider.students)

        binding!!.recycleView.adapter = studentAdapter
        binding!!.recycleView.layoutManager = LinearLayoutManager(requireContext())


        return binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}