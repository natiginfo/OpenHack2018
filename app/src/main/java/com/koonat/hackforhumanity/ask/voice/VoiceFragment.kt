package com.koonat.hackforhumanity.ask.voice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseFragment

/**
 * Created by Natig on 3/11/18.
 */
class VoiceFragment : BaseFragment() {

    private lateinit var currentView: View

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        currentView = inflater.inflate(R.layout.fragment_voice, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}