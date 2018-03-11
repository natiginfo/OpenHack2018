package com.koonat.hackforhumanity.country

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindArray
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.koonat.hackforhumanity.home.HomeActivity
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseActivity

/**
 * Created by Natig on 3/11/18.
 */
class ChooseCountryActivity : BaseActivity() {
    @BindView(R.id.languagesRecyclerView)
    lateinit var recyclerView: RecyclerView

    @BindArray(R.array.countries_array)
    lateinit var countries: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_location)
        ButterKnife.bind(this)

        val recyclerLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = recyclerLayoutManager

        val checkBoxAdapter = CountryAdapter(countries.toList())

        recyclerView.adapter = checkBoxAdapter
    }

    @OnClick(R.id.btn_next)
    fun onNextClicked() {
        startActivity(HomeActivity().newIntent(this))
        finish()
    }
}