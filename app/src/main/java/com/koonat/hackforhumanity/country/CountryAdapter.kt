package com.koonat.hackforhumanity.country

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

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private var countryList: List<String>

    constructor(languageList: List<String>) {
        this.countryList = languageList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_checkbox_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currentElement = countryList[position]
        holder?.titleTextView?.text = currentElement
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var titleTextView = itemView?.findViewById(R.id.title) as TextView
        var checkBox = itemView?.findViewById(R.id.checkbox) as CheckBox

        init {
            itemView?.setOnClickListener(this)
            checkBox.visibility = View.GONE
        }

        override fun onClick(v: View?) {

        }
    }
}