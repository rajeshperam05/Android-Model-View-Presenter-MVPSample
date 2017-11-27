package com.rajesh.mvpsample.result;

import android.os.Handler;

/**
 * Created by rajesh on 27/11/17.
 */

public class ResultPresenterImpl implements ResultPresenter, ResultInterpreter.OnResultInterpreterListener, ResultInterpreter.OnResultBindListener {
    ResultView resultView;
    ResultInterpreter interpreter;

    public ResultPresenterImpl(ResultView resultView) {
        this.resultView = resultView;
        interpreter = new ResultInterpreterImpl();
    }

    @Override
    public void bindData(String name, String password) {

        if (resultView != null){
            resultView.showProgress();
            interpreter.bindData(name, password, this);
        }
    }

    @Override
    public void sendData(String name, String password) {

        if (resultView != null){
            resultView.showProgress();
            interpreter.result(name, password, this);
        }
    }

    @Override
    public void onDestroy() {
        if (resultView != null) {
            resultView = null;
        }
    }

    @Override
    public void onSuccess(String name, String password) {

        if (resultView != null) {
            resultView.hideProgress();
            resultView.onNavigate(name, password);
        }
    }

    @Override
    public void onFailure(String message) {

        if (resultView != null) {
            resultView.hideProgress();
            resultView.showAlert(message);
        }
    }

    @Override
    public void onBindSuccess(String name, String password) {

        if (resultView != null) {
            resultView.bindData(name, password);
            resultView.hideProgress();
        }
    }

    @Override
    public void onBindFailure(String message) {

        if (resultView != null) {
            resultView.hideProgress();
            resultView.showAlert(message);
        }
    }
}
