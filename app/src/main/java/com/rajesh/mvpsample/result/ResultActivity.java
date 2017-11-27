package com.rajesh.mvpsample.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rajesh.mvpsample.R;

/**
 * Created by rajesh on 27/11/17.
 */

public class ResultActivity extends AppCompatActivity implements ResultView{

    private TextView tvName, tvPassword;
    private Button btnReturn;
    private ProgressBar pbProgress;
    private String name, password;
    private ResultPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = getIntent().getStringExtra(getResources().getString(R.string.user_name));
        password = getIntent().getStringExtra(getResources().getString(R.string.password));

        setContentView(R.layout.activity_result);

        tvName = (TextView) findViewById(R.id.tvName);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        pbProgress = (ProgressBar) findViewById(R.id.pbProgress);

        presenter = new ResultPresenterImpl(this);

        presenter.bindData(name, password);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.sendData(name, password);
            }
        });
    }

    @Override
    public void bindData(String name, String password) {

        tvName.setText(name);
        tvPassword.setText(password);
    }

    @Override
    public void showProgress() {

        pbProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void onNavigate(String name, String password) {

        Intent intent = new Intent();
        intent.putExtra(getResources().getString(R.string.user_name), name);
        intent.putExtra(getResources().getString(R.string.password), password);
        setResult(getResources().getInteger(R.integer.Result_Intent_Request), intent);
        finish();
    }

    @Override
    public void showAlert(String message) {

        Toast.makeText(ResultActivity.this, message, Toast.LENGTH_LONG).show();

    }
}
