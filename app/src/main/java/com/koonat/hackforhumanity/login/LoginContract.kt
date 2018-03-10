package com.koonat.hackforhumanity.login

import com.koonat.hackforhumanity.common.base.mvp.BasePresenter
import com.koonat.hackforhumanity.common.base.mvp.BaseView


/**
 * Created by Natig on 3/10/18.
 */

interface LoginContract {
    interface Presenter : BasePresenter {
        fun sendVerificationSms(phone: String, nickname: String)
    }

    interface View : BaseView<Presenter> {
        fun sendVerificationSms(phone: String)

        fun showProgress()

        fun removeProgress()

        fun onVerificationSmsSent()

        fun onLoggedIn()

        fun onError(throwable: Throwable)
    }
}
