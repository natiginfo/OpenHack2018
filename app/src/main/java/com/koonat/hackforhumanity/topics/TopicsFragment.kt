package com.koonat.hackforhumanity.topics

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseFragment

/**
 * Created by Natig on 3/11/18.
 */
class TopicsFragment : BaseFragment() {
    lateinit var currentView: View

    @BindView(R.id.topicsRecyclerView)
    lateinit var topicsRecyclerView: RecyclerView

    lateinit var topicsList: List<Topic>

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        currentView = inflater.inflate(R.layout.fragment_topics, container, false)
        ButterKnife.bind(this, currentView)

        val recyclerLayoutManager = LinearLayoutManager(context)
        topicsRecyclerView.layoutManager = recyclerLayoutManager

        val topic1 = Topic("Money & Banking",
                resources.getDrawable(R.drawable.ic_bank),
                Color.parseColor("#7097fc"))

        val topic2 = Topic("Internet & Apps",
                resources.getDrawable(R.drawable.ic_globe),
                Color.parseColor("#816efb"))

        val topic3 = Topic("Smartphones",
                resources.getDrawable(R.drawable.ic_phone),
                Color.parseColor("#b173fc"))

        val topic4 = Topic("Health & Hospital",
                resources.getDrawable(R.drawable.ic_home),
                Color.parseColor("#73d5fd"))

        topicsList = arrayOf(topic1, topic2, topic3, topic4).toList()

        val checkBoxAdapter = TopicsAdapter(topicsList, object : TopicsAdapter.OnItemClickedListener {

            override fun onClick(topic: Topic) {
                Log.d("TopicsFragment", topic.title)
            }
        })

        topicsRecyclerView.adapter = checkBoxAdapter
        return currentView
    }

    companion object {
        fun newInstance(): TopicsFragment {
            val topicsFragment = TopicsFragment()
            return topicsFragment
        }
    }
}