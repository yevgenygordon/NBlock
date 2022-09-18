package com.example.nblock

import androidx.lifecycle.ViewModel
import com.example.nblock.data.DataSource
import com.example.nblock.data.model.Note

class MainViewModel : ViewModel() {

    private val repository = DataSource()

    private var _noteList = mutableListOf<Note>()
    val noteList: List<Note>
        get() = _noteList

    private var _position = 0
    val position: Int
        get() = _position

    // wird einmal beim Erstellen des ViewModels ausgeführt
    init {
        _noteList = repository.loadNotes()
    }

    fun updateNote(oldText: String, newTitle: String, newText: String) {
        val note = _noteList.find { it.text == oldText }

        if (note != null) {
            note.title = newTitle
            note.text = newText
            _position = _noteList.indexOf(note)
        } else {
            newNote(newTitle, newText)
        }
    }

    private fun newNote(title: String, text: String) {
        val newNote = Note(title, text)
        _noteList.add(0, newNote)
        _position = 0
    }
}