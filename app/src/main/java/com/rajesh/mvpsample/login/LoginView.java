package com.rajesh.mvpsample.login;

/**
 * Created by rajesh on 27/11/17.
 */

public interface LoginView {

    /*Hide the progress bar*/
    void hideProgress();

    /*Show Progress bar*/
    void showProgress();

    /* set Error message for username edit text*/
    void setUserNameError();

    /* set Error message for password edit text*/
    void setPasswordError();

    /* After login success navigation process
    * @param name = username
    * @param password = password*/
    void navigateToMain(String name, String password);

    /* After return from second screen*/
    void onReturnSuccess(String name, String password);

    /* Show alert messages*/
    void showAlert(String message);
}
