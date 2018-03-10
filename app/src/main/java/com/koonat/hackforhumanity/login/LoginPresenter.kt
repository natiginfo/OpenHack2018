package com.koonat.hackforhumanity.login

import com.koonat.hackforhumanity.login.data.SmsVerificationRepository

/**
 * Created by Natig on 3/10/18.
 */

class LoginPresenter(val smsVerificationRepository: SmsVerificationRepository,
                     val view: LoginContract.View) : LoginContract.Presenter {

    override fun sendVerificationSms(phone: String, nickname: String) {
    }

    override fun start() {

    }

}
