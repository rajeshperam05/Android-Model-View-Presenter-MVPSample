package com.rajesh.mvpsample.result;

/**
 * Created by rajesh on 27/11/17.
 */

public interface ResultView {

    /* Bind data form First activity*/
    void bindData(String name, String password);

    /* Show progress bar*/
    void showProgress();

    /*Hide Progress bar*/
    void hideProgress();

    /* Navigate to First activity with data*/
    void onNavigate(String name, String password);

    /* Alert message with data*/
    void showAlert(String message);
}
