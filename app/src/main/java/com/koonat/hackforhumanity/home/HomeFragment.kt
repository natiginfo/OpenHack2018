package com.koonat.hackforhumanity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseFragment

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

    companion object {
        fun newInstance(): HomeFragment {
            val homeFragment = HomeFragment()
            return homeFragment
        }
    }
}
