package com.codekul.mvp.login;

/**
 * Created by aniruddha on 14/9/17.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
    }

    @Override
    public boolean checkUserNameAvalability(String userName) {
        interactor.checkUserName(userName, status -> {
            if (status.equals("codekul")) view.showTickMark(true);
            else view.showTickMark(false);
        });
        return false;
    }

    @Override
    public boolean doLoin(String userName, String pass) {
        interactor.login(userName, pass, status -> {

        });
        return false;
    }
}
