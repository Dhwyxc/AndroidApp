package com.ndhuy19it1.menuexam

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ndhuy19it1.menuexam.R
import com.ndhuy19it1.menuexam.adapter.StudentAdapter
import com.ndhuy19it1.menuexam.databinding.FragmentFirstBinding
import com.ndhuy19it1.menuexam.databinding.FragmentSecondBinding
class SecondFragment : Fragment() {

    private var binding : FragmentSecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)

        val popupMenu = PopupMenu(requireContext(), binding!!.button)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener {menuItem ->
            when(menuItem.itemId){
                R.id.aboutMe_menu -> {
                    findNavController().navigate(R.id.action_secondFragment_to_aboutMeFragment)

                    true
                }
                else -> false
            }
        }
        binding!!.button.setOnClickListener { popupMenu.show() }
        return binding!!.root
    }

}