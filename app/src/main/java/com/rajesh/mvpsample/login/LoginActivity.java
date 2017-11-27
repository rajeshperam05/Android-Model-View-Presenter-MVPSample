package com.rajesh.mvpsample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rajesh.mvpsample.R;
import com.rajesh.mvpsample.result.ResultActivity;

/**
 * Created by rajesh on 27/11/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText etUserName, etPassword;
    private Button btnSend;
    private ProgressBar pbProgress;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSend = (Button) findViewById(R.id.btnSend);
        pbProgress = (ProgressBar) findViewById(R.id.pbProgress);

        loginPresenter = new LoginPresenterImpl(this);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginPresenter.validateCred(etUserName.getText().toString().trim(),
                        etPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void setUserNameError() {
        etUserName.setError("User Name is Empty");
    }

    @Override
    public void setPasswordError() {
        etPassword.setError("Password is Epty");
    }

    @Override
    public void navigateToMain(String name, String password) {

        Intent intent = new Intent(LoginActivity.this, ResultActivity.class);
        intent.putExtra(getResources().getString(R.string.user_name), name);
        intent.putExtra(getResources().getString(R.string.password), password);
        startActivityForResult(intent, getResources().getInteger(R.integer.Result_Intent_Request));
        etUserName.setText("");
        etPassword.setText("");
    }

    @Override
    public void onReturnSuccess(String name, String password) {
        etUserName.setText(name);
        etPassword.setText(password);
        Toast.makeText(LoginActivity.this, name + "  " + password, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getResources().getInteger(R.integer.Result_Intent_Request) && requestCode == getResources().getInteger(R.integer.Result_Intent_Request)){

            String name = data.getStringExtra(getResources().getString(R.string.user_name));
            String password = data.getStringExtra(getResources().getString(R.string.password));

            loginPresenter.returnResult(name, password);
        }
    }
}
