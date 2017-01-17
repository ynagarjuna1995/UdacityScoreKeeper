package com.example.nagarjuna.scoreapp.contract;

import android.view.View;

import com.example.nagarjuna.scoreapp.BasePresenter;
import com.example.nagarjuna.scoreapp.BaseView;

public interface scoreBoardContract {
    interface View extends BaseView<Presenter>{
        void showResetWithToast(String message);
        void showScoreForTeamA(Integer score);
        void showScoreForTeamB(Integer score);
        void configureLayout();
    }

    interface Presenter extends BasePresenter{
        void resetWithToast(android.view.View view);
        void btnListenerForScoreA(android.view.View view);
        void btnListnerForScoreB(android.view.View view);
    }
}
