package com.prproject.view.adapter
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prproject.R
import com.prproject.listener.CellClickListener
import com.prproject.model.PRData
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(private val mAct:Activity,private val prData: MutableList<PRData>,
                          private val cellClickListener: CellClickListener
)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // display the current color
        holder.title.text = prData[position].author
        holder.description.text = prData[position].description
        holder.publishedAt.text = prData[position].publishedAt
        val media = prData[position].urlToImage
        if (media !== null) {
            Glide.with(mAct)
                .load(media)
                .into( holder.imageView)
        } else {
            holder.imageView.setImageResource(R.drawable.ic_launcher_background)
        }
        val data = prData[position]
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }

    }


    override fun getItemCount(): Int {
        // number of items in the data set held by the adapter
        return prData.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title:TextView = itemView.tvName
        val description:TextView  = itemView.glucoseLevel
        val publishedAt:TextView = itemView.createdAt
        val imageView:ImageView = itemView.imgView
    }


    // this two methods useful for avoiding duplicate item
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

}