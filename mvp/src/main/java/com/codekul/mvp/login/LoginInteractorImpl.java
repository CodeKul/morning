package com.codekul.mvp.login;

/**
 * Created by aniruddha on 14/9/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(String usNm, String pass, LoginListener listener) {
        if (usNm.equals("android") && pass.equals("codekul")) listener.onOperation("success");
        else listener.onOperation("fail");
    }

    @Override
    public void checkUserName(String usNm, LoginListener listener) {
        if (usNm.equals("codekul")) listener.onOperation("true");
        else listener.onOperation("false");
    }
}
