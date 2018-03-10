package com.koonat.hackforhumanity.login;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.PhoneAuthProvider;
import com.koonat.hackforhumanity.MainActivity;
import com.koonat.hackforhumanity.R;
import com.koonat.hackforhumanity.common.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private static final String TAG = "LoginActivity";

    private LoginContract.Presenter presenter;
    @BindView(R.id.login_view) ConstraintLayout loginHolder;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.edit_phone) EditText phoneEditText;
    @BindView(R.id.edit_username) EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
        presenter.start();
    }

    @OnClick(R.id.btn_login)
    void loginButtonClicked() {
        presenter.sendVerificationSms(phoneEditText.getText().toString(),
                usernameEditText.getText().toString());
    }

    @Override
    public void sendVerificationSms(String phone) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 30, TimeUnit.SECONDS, this,
                (PhoneAuthProvider.OnVerificationStateChangedCallbacks) presenter);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {
        Log.d(TAG, "showProgress: ");
        loginHolder.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeProgress() {
        Log.d(TAG, "removeProgress: ");
        loginHolder.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onVerificationSmsSent() {
        Log.d(TAG, "onVerificationSmsSent: ");
    }

    @Override
    public void onLoggedIn() {
        Log.d(TAG, "onLoggedIn: ");
        startActivity(new MainActivity().newIntent(this));
        finish();
    }

    @Override
    public void onError(Throwable throwable) {
        Log.d(TAG, "onError: " + throwable.getMessage());
    }
}