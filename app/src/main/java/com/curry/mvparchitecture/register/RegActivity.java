package com.curry.mvparchitecture.register;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.curry.mvparchitecture.Login.LoginPresenter;
import com.curry.mvparchitecture.Login.LoginPresenterImpl;
import com.curry.mvparchitecture.R;
import com.curry.mvparchitecture.MainActivity;

public class RegActivity extends Activity implements RegView,View.OnClickListener {
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private RegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new RegPresenterImp(this);
    }

    @Override
    protected void onDestroy() {
        presenter.finishReg();
        super.onDestroy();
    }

    @Override
    public void showProgressView() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressView() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        username.setError(getString(R.string.username_error));
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void guide2Home() {
        startActivity(new Intent(RegActivity.this,MainActivity.class));
    }

    @Override
    public void onClick(View v) {
        presenter.checkInfos(username.getText().toString(), password.getText().toString());
    }
}
