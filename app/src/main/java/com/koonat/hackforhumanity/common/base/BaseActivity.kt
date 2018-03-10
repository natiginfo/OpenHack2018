package com.koonat.hackforhumanity.common.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity


/**
 * Created by Natig on 3/10/18.
 */

open class BaseActivity : AppCompatActivity() {
    fun newIntent(activity: Activity): Intent {
        return Intent(activity, javaClass)
    }

    fun newIntent(context: Context): Intent {
        return Intent(context, javaClass)
    }

    fun newIntentWithoutHistory(activity: Activity): Intent {
        val intent = Intent(activity, this.javaClass)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        return intent
    }
}
