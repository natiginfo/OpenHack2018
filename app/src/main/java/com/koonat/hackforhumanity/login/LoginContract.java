package com.koonat.hackforhumanity.login;


import com.koonat.hackforhumanity.common.base.mvp.BasePresenter;
import com.koonat.hackforhumanity.common.base.mvp.BaseView;

/**
 * Created by Natig on 10/7/17.
 */

class LoginContract {
    interface Presenter extends BasePresenter {
        void sendVerificationSms(String phone, String nickname);
    }

    interface View extends BaseView<Presenter> {
        void sendVerificationSms(String phone);

        void showProgress();

        void removeProgress();

        void onVerificationSmsSent();

        void onLoggedIn();

        void onError(Throwable throwable);
    }
}