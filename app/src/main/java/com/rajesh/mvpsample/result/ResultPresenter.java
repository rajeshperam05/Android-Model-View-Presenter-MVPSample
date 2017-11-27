package com.rajesh.mvpsample.result;

/**
 * Created by rajesh on 27/11/17.
 */

public interface ResultPresenter {

    /* Bind data comes from First activity*/
    void bindData(String name, String password);

    /* Send data to First activity*/
    void sendData(String name, String password);

    /*Destroy view when no longer use*/
    void onDestroy();
}
