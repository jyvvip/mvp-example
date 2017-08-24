package com.curry.mvparchitecture.register;

import com.curry.mvparchitecture.Login.LoginInteractor;
import com.curry.mvparchitecture.Login.LoginInteractorImpl;
import com.curry.mvparchitecture.Login.LoginPresenter;
import com.curry.mvparchitecture.Login.LoginView;

/**
 * Created by Curry on 2017/8/24.
 */

public class RegPresenterImp implements RegPresenter,RegFinishListener {
    private RegView regView;
    private RegChecker regChecker;


    public RegPresenterImp(RegView regView) {
        this.regView = regView;
        this.regChecker = new RegCheckerImp();
    }

    @Override
    public void checkInfos(String username, String password) {
        if (regView != null) {
            regView.showProgressView();
        }
        regChecker.checkReg(username,password,this);
    }

    @Override
    public void finishReg() {
        regView = null;
    }

    @Override
    public void onError() {
        if (regView != null) {
            regView.showError();
            regView.hideProgressView();
        }
    }

    @Override
    public void onSuccess() {
        if (regView != null) {
            regView.guide2Home();
        }
    }
}