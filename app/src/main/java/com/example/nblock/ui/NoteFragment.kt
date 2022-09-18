package com.example.nblock.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nblock.MainViewModel
import com.example.nblock.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    // wenn sich mehere Fragmente ein ViewModel teilen -> activityViewModels
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val title = requireArguments().getString("title", "")
        val text = requireArguments().getString("text", "")

        binding.noteTitelEditText.setText(title)
        binding.noteTextEditText.setText(text)

        binding.saveButton.setOnClickListener {
            val newTitle = binding.noteTitelEditText.text.toString()
            val newText = binding.noteTextEditText.text.toString()

            viewModel.updateNote(text, newTitle, newText)

            findNavController().navigate(NoteFragmentDirections.actionNoteFragmentToHomeFragment())
        }
    }
}
