package com.koonat.hackforhumanity.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koonat.hackforhumanity.common.base.BaseFragment

/**
 * Created by Natig on 3/10/18.
 */

class LoginFragment : BaseFragment(), LoginContract.View {

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendVerificationSms(phone: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onVerificationSmsSent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoggedIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
