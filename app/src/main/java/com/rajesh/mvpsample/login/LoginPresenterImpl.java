package com.rajesh.mvpsample.login;

/**
 * Created by rajesh on 27/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInterpreter.OnLoginFinishedListener, LoginInterpreter.OnLoginReturnListener {

    LoginView loginView;
    LoginInterpreter loginInterpreter;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInterpreter = new LoginInterpreterImpl();
    }

    @Override
    public void validateCred(String name, String password) {

        if (loginView != null) {
            loginView.showProgress();
            loginInterpreter.login(name, password, this);
        }

    }

    @Override
    public void onDestroy() {

        if (loginView != null)
            loginView = null;

    }

    @Override
    public void returnResult(String name, String password) {

        if (loginView != null){
            loginView.showProgress();
            loginInterpreter.returnData(name, password, this);
        }
    }

    @Override
    public void onUserNameError() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.setUserNameError();
        }

    }

    @Override
    public void onPasswordError() {

        if (loginView != null) {
            loginView.hideProgress();
            loginView.setPasswordError();
        }

    }

    @Override
    public void onSuccess(String name, String password) {

        if (loginView != null) {
            loginView.hideProgress();
            loginView.navigateToMain(name, password);
        }

    }

    @Override
    public void onSuccessReturn(String name, String password) {

        if (loginView != null) {
            loginView.hideProgress();
            loginView.onReturnSuccess(name, password);
        }
    }

    @Override
    public void onFailure(String message) {

        if (loginView != null){
            loginView.hideProgress();
            loginView.showAlert(message);
        }

    }
}
