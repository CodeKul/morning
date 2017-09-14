package com.codekul.mvp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codekul.mvp.MyApp;
import com.codekul.mvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenterImpl(this);

        MyApp app = (MyApp) this.getApplication();
        //app.getSocket().getOutputStream().write("".getBytes());
    }

    @Override
    public void login(String usNm, String pass) {
        presenter.doLoin(usNm, pass);
    }

    @Override
    public void showTickMark(boolean tick) {

    }
}
