package com.example.logindemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.logindemo.R;
import com.example.logindemo.model.LoginModel;
import com.example.logindemo.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    private EditText name;
    private EditText pwd;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initDatas();
    }
    private void initDatas() {
        name = findViewById (R.id.name);

        pwd = findViewById (R.id.pwd);

        bar = findViewById (R.id.bar);

        Button login = findViewById (R.id.login);

        login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LoginPresenter presenterImpel = new LoginPresenter();

                presenterImpel.ShowLoginToView (new LoginModel(),LoginActivity.this);
            }
        });

        Button reg = findViewById (R.id.reg);

        reg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent(LoginActivity.this,RegActivity.class));
            }
        });
    }

    @Override
    public String getMobile() {
        return name.getText ().toString ();
    }

    @Override
    public String getPwd() {
        return pwd.getText ().toString ();
    }

    @Override
    public void showSuccess() {
        /*  bar.set*/
        bar.setVisibility (ProgressBar.VISIBLE);
        Toast.makeText (LoginActivity.this,"登录成功··跳转页面",Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void showError() {
        bar.setVisibility (ProgressBar.GONE);
        Toast.makeText (LoginActivity.this,"登录失败··",Toast.LENGTH_SHORT).show ();
    }
}
