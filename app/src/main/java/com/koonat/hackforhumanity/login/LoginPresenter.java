package com.koonat.hackforhumanity.login;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/**
 * Created by Natig on 10/7/17.
 */

public class LoginPresenter extends PhoneAuthProvider.OnVerificationStateChangedCallbacks
        implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        // check if logged in
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            view.onLoggedIn();
        }
    }

    @Override
    public void sendVerificationSms(String phone) {
        view.sendVerificationSms(phone);
        view.showProgress();
    }

    @Override
    public void onVerificationFailed(FirebaseException e) {
        view.onError(new Throwable(e.getMessage()));
    }

    @Override
    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        super.onCodeSent(s, forceResendingToken);
        view.onVerificationSmsSent();
    }

    @Override
    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        // start login
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(task -> signIn());
    }

    private void signIn() {
        updateUserProfile();
    }

    private void updateUserProfile() {
        view.onLoggedIn();
        view.removeProgress();
    }
}