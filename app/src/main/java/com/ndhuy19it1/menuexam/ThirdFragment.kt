package com.ndhuy19it1.menuexam

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.ndhuy19it1.menuexam.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var binding : FragmentThirdBinding? = null
    private var actionMode: ActionMode? = null

    private val actionModelCallback = object : ActionMode.Callback{
        override fun onCreateActionMode(mode: ActionMode, menu: Menu?): Boolean {
            val inflater = mode.menuInflater
            inflater.inflate(R.menu.context_menu, menu)
            return true
        }
        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when(item.itemId){
                R.id.done_menu -> {
                    mode.finish()
                    true
                }
                else -> false
            }
        }
        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(layoutInflater)

        binding!!.textview.setOnLongClickListener {view ->
            when(actionMode){
                null -> {
                    actionMode = activity?.startActionMode(actionModelCallback)
                    view.isSelected = true
                    true
                }
                else -> false
            }
        }
        return binding!!.root
    }

}