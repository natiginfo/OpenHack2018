package com.koonat.hackforhumanity

import android.os.Bundle
import com.koonat.hackforhumanity.common.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(RecordActivity().newIntent(this))
    }
}