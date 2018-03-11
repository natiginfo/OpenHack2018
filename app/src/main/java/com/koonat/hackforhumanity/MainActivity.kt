package com.koonat.hackforhumanity

import android.os.Bundle
import com.koonat.hackforhumanity.common.base.BaseActivity
import com.koonat.hackforhumanity.language.ChooseLanguageActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(ChooseLanguageActivity().newIntent(this))
        finish()
    }
}