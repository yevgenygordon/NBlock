package com.example.nblock.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nblock.R
import com.example.nblock.data.model.Note
import com.example.nblock.ui.HomeFragmentDirections

class NoteAdapter(
    private val dataset: List<Note>) : RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_TextView)
        val text: TextView = view.findViewById(R.id.text_TextView)
        val editImage: ImageView = view.findViewById(R.id.edit_imageView)
        val deleteImage: ImageView = view.findViewById(R.id.delete_imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.title.text = item.title
        holder.text.text = item.text

        holder.editImage.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(
                    HomeFragmentDirections
                        .actionHomeFragmentToNoteFragment(item.title, item.text)
                )
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}