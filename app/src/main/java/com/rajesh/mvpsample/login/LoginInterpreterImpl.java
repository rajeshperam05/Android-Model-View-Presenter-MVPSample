package com.rajesh.mvpsample.login;

import android.text.TextUtils;

import java.util.logging.Handler;

/**
 * Created by rajesh on 27/11/17.
 */

public class LoginInterpreterImpl implements LoginInterpreter {

    @Override
    public void login(final String name, final String password, final OnLoginFinishedListener listener) {

        if (TextUtils.isEmpty(name)){
            listener.onUserNameError();
        }else if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
        }else if (name.equals("admin") && password.equals("12345")) {
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess(name, password);
                }
            }, 3000);

        }else {
            listener.onFailure("Invalid Credentials");
        }

    }

    @Override
    public void returnData(final String name, final String password, final OnLoginReturnListener listener) {

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onSuccessReturn(name, password);
            }
        }, 3000);
    }
}
