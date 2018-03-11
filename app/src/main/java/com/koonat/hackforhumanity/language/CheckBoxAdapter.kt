package com.koonat.hackforhumanity.language

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.koonat.hackforhumanity.R


/**
 * Created by Natig on 3/11/18.
 */

class CheckBoxAdapter : RecyclerView.Adapter<CheckBoxAdapter.ViewHolder> {
    private var languageList: List<String>

    constructor(languageList: List<String>) {
        this.languageList = languageList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_checkbox_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currentElement = languageList[position]
        holder?.titleTextView?.text = currentElement
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var titleTextView = itemView?.findViewById(R.id.title) as TextView
        var checkBox = itemView?.findViewById(R.id.checkbox) as CheckBox

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }
}