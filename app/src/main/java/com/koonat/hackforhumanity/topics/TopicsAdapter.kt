package com.koonat.hackforhumanity.topics

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.koonat.hackforhumanity.R


/**
 * Created by Natig on 3/11/18.
 */

class TopicsAdapter : RecyclerView.Adapter<TopicsAdapter.ViewHolder> {
    private var topics: List<Topic>
    private var onItemClickedListener: OnItemClickedListener

    constructor(topics: List<Topic>, onItemClickedListener: OnItemClickedListener) {
        this.topics = topics
        this.onItemClickedListener = onItemClickedListener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_topic, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currentElement = topics[position]
        holder?.click(currentElement, onItemClickedListener)
        holder?.titleTextView?.text = currentElement.title
        holder?.icon?.setImageDrawable(currentElement.icon)
        holder?.earHolder?.setBackgroundColor(currentElement.backgroundColor)
        holder?.topicDetailsHolder?.setBackgroundColor(currentElement.backgroundColor)

    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var titleTextView = itemView?.findViewById(R.id.topicTitle) as TextView
        var topicHolder = itemView?.findViewById(R.id.topicHolder) as RelativeLayout
        var earHolder = itemView?.findViewById(R.id.topicEarHolder) as RelativeLayout
        var topicDetailsHolder = itemView?.findViewById(R.id.topicDetailsHolder) as RelativeLayout
        var icon = itemView?.findViewById(R.id.icon) as ImageView

        fun click(topic: Topic, onItemClickedListener: OnItemClickedListener) {
            topicHolder.setOnClickListener({
                onItemClickedListener.onClick(topic)
            })
        }
    }

    interface OnItemClickedListener {
        fun onClick(topic: Topic)
    }
}

data class Topic(var title: String, val icon: Drawable, val backgroundColor: Int)