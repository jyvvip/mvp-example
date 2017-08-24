package com.curry.mvparchitecture.register;

/**
 * Created by Curry on 2017/8/24.
 */

public interface RegChecker {
    void checkReg(String name,String pwd,RegFinishListener listener);
}
