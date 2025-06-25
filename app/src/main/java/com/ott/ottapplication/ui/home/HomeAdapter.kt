package com.ott.ottapplication.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.ott.ottapplication.R
import com.ott.ottapplication.models.Videos

class HomeAdapter : Adapter<HomeAdapter.ViewHolder>() {

    lateinit var data: ArrayList<Videos>

    private lateinit var callback: (result: Videos) -> Unit

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val cardView: CardView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.title)
            cardView = view.findViewById(R.id.card_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    fun setContent(videos: ArrayList<Videos>) {
        this.data = videos
    }

    fun setClickListener(callbacks: (result: Videos) -> Unit) {
        this.callback = callbacks
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = data[position].title
        viewHolder.cardView.setOnClickListener {
            callback.invoke(data[position])
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.size

}