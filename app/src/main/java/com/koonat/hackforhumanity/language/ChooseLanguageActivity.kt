package com.koonat.hackforhumanity.language

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import butterknife.BindArray
import butterknife.BindView
import butterknife.ButterKnife
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseActivity
import android.support.v7.widget.LinearLayoutManager


/**
 * Created by Natig on 3/11/18.
 */

class ChooseLanguageActivity : BaseActivity() {

    @BindView(R.id.languagesRecyclerView)
    lateinit var recyclerView: RecyclerView

    @BindArray(R.array.languages)
    lateinit var languagesList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_language)
        ButterKnife.bind(this)
        val recyclerLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = recyclerLayoutManager

        val checkBoxAdapter = CheckBoxAdapter(languagesList.toList())

        recyclerView.adapter = checkBoxAdapter
    }
}
