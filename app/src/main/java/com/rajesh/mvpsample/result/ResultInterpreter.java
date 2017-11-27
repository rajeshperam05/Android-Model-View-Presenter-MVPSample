package com.rajesh.mvpsample.result;

/**
 * Created by rajesh on 27/11/17.
 */

public interface ResultInterpreter {

    /* Listener for return data*/
    interface OnResultInterpreterListener {

        void onSuccess(String name, String password);
        void onFailure(String message);
    }

    /* Return data to First Activity*/
    void result(String name, String password, OnResultInterpreterListener listener);

    /* Listener to bind data from First activity*/
    interface OnResultBindListener {

        void onBindSuccess(String name, String password);
        void onBindFailure(String message);
    }

    /* Bind data comes form First activity*/
    void bindData(String name, String password, OnResultBindListener listener);
}
