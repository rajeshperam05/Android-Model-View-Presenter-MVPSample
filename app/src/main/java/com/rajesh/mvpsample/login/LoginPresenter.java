package com.rajesh.mvpsample.login;

/**
 * Created by rajesh on 27/11/17.
 */

public interface LoginPresenter {

    /* Validate the user credentials*/
    void validateCred(String name, String password);

    /* Destroy view when no longer use*/
    void onDestroy();

    /* After successful return from second screen process*/
    void returnResult(String name, String password);
}
