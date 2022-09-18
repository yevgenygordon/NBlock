package com.example.nblock.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.nblock.MainViewModel
import com.example.nblock.adapter.NoteAdapter
import com.example.nblock.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    // wenn sich mehere Fragmente ein ViewModel teilen -> activityViewModels
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteList = viewModel.noteList

        binding.homeRecycler.adapter = NoteAdapter(noteList)

        binding.homeRecycler.scrollToPosition(viewModel.position)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.homeRecycler)

        binding.FAB.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToNoteFragment("", "")
            )
      }



    }
}

//2E0944