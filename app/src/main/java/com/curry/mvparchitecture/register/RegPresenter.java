package com.curry.mvparchitecture.register;

/**
 * Created by Curry on 2017/8/24.
 */

public interface RegPresenter {
    void checkInfos(String username, String password);
    void finishReg();
}
