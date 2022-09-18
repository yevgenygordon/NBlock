package com.example.nblock.data
import com.example.nblock.data.model.Note

class DataSource {
    fun loadNotes(): MutableList<Note> {
        return mutableListOf(
            Note(
                "Home",
                "Wasche in die Waschmaschine"
            ),
            Note(
                "Wochenende",
                "Party in der Kneipe"
            ),
            Note(
                "Random",
                "Notizblock ksdjflsdkfjls sokfsfsfjsf" +
                        "sfsfsfsfssgs dfdfddllele"
            )
        )
    }
}