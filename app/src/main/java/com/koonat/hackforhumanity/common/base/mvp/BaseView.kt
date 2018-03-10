package com.koonat.hackforhumanity.common.base.mvp

/**
 * Created by Natig on 3/10/18.
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}
