package com.koonat.hackforhumanity.country

import android.os.Bundle
import butterknife.ButterKnife
import com.koonat.hackforhumanity.R
import com.koonat.hackforhumanity.common.base.BaseActivity

/**
 * Created by Natig on 3/11/18.
 */
class ChooseCountryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_location)
        ButterKnife.bind(this)
    }
}