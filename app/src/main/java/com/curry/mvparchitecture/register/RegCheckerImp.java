package com.curry.mvparchitecture.register;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Curry on 2017/8/24.
 */

public class RegCheckerImp implements RegChecker {

    @Override
    public void checkReg(final String name,final String pwd,final RegFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
                    listener.onError();
                }else {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
