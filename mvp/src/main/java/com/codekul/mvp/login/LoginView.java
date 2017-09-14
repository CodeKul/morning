package com.codekul.mvp.login;

/**
 * Created by aniruddha on 14/9/17.
 */

public interface LoginView {

    void login(String usNm, String pass);

    void showTickMark(boolean tick);
}
