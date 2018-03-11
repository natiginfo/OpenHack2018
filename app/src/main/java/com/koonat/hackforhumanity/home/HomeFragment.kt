package com.koonat.hackforhumanity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseFragment
import com.koonat.hackforhumanity.topics.TopicsFragment

/**
 * Created by Natig on 3/11/18.
 */

class HomeFragment : BaseFragment() {
    private lateinit var currentView: View


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        currentView = inflater.inflate(R.layout.fragment_learner_or_helper, container, false)
        ButterKnife.bind(this, currentView)
        return currentView
    }

    @OnClick(R.id.btn_need_help)
    fun needHelpClicked() {
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.home_fragment_holder, TopicsFragment.newInstance())
                ?.addToBackStack("NeedHelp")
                ?.commit()
    }

    companion object {
        fun newInstance(): HomeFragment {
            val homeFragment = HomeFragment()
            return homeFragment
        }
    }
}
