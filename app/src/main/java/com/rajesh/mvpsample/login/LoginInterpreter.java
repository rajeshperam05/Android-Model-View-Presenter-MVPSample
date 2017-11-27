package com.rajesh.mvpsample.login;

/**
 * Created by rajesh on 27/11/17.
 */

public interface LoginInterpreter {

    /* Listener for user validation checking*/
    interface OnLoginFinishedListener {

        void onUserNameError();
        void onPasswordError();
        void onSuccess(String name, String password);
        void onFailure(String message);
    }

    /* User validation check with listener*/
    void login(String name, String password, OnLoginFinishedListener listener);

    /* Listener for data return back form second screen*/
    interface OnLoginReturnListener {

        void onSuccessReturn(String name, String password);
        void onFailure(String message);
    }

    /* Return data form second activity to binding*/
    void returnData(String name, String password, OnLoginReturnListener listener);
}
