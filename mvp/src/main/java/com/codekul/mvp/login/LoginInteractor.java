package com.codekul.mvp.login;

/**
 * Created by aniruddha on 14/9/17.
 */

public interface LoginInteractor {

    interface LoginListener {
        void onOperation(String status);
    }

    void login(String usNm, String pass, LoginListener listener);

    void checkUserName(String usNm, LoginListener listener);
}
