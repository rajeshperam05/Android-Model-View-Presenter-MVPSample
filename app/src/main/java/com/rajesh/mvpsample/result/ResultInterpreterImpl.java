package com.rajesh.mvpsample.result;

import android.os.Handler;

/**
 * Created by rajesh on 27/11/17.
 */

public class ResultInterpreterImpl implements ResultInterpreter {

    @Override
    public void result(final String name, final String password, final OnResultInterpreterListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onSuccess(name, password);
            }
        }, 3000);



    }

    @Override
    public void bindData(final String name, final String password, final OnResultBindListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onBindSuccess(name, password);
            }
        }, 3000);
    }
}
