package com.example.logindemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.logindemo.R;
import com.example.logindemo.model.LoginModel;
import com.example.logindemo.presenter.LoginPresenter;

public class RegActivity extends AppCompatActivity implements IRegView{
    private EditText name;
    private EditText pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initDatas();
    }
    private void initDatas() {
        name = findViewById (R.id.name);

        pwd = findViewById (R.id.pwd);

        Button reg = findViewById (R.id.reg);

        reg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LoginPresenter presenterImpel = new LoginPresenter();

                presenterImpel.ShowRegToView (new LoginModel(),RegActivity.this);
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
        Toast.makeText (this,"注册成功--",Toast.LENGTH_SHORT).show ();

        startActivity (new Intent(RegActivity.this,LoginActivity.class));
    }

    @Override
    public void showError() {
        Toast.makeText (this,"注册失败--",Toast.LENGTH_SHORT).show ();
    }
}
