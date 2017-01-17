package com.example.nagarjuna.scoreapp.presenter;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.nagarjuna.scoreapp.R;
import com.example.nagarjuna.scoreapp.contract.scoreBoardContract;
import com.example.nagarjuna.scoreapp.teamAndScore;

import static com.google.common.base.Preconditions.checkNotNull;



public class ScoreBoardPresenter implements scoreBoardContract.Presenter {

    @NonNull
    private scoreBoardContract.View mScoreBoardView;


    private Integer _SCORE_4_POINT = 4;
    private Integer _SCORE_1_POINT = 1;
    private Integer _SCORE_3_POINT = 3;
    private Integer _SCORE_7_POINT = 7;

    private teamAndScore teamA = new teamAndScore(0,"A");
    private teamAndScore teamB = new teamAndScore(0,"B");


    public ScoreBoardPresenter(@NonNull scoreBoardContract.View ScoreBoardView) {
        mScoreBoardView = checkNotNull(ScoreBoardView, "tasksView cannot be null!");
        mScoreBoardView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void resetWithToast(View v) {
        teamA.Score = 0;
        teamB.Score = 0;
        String message = "Scores Succesfully Resetted !";
        mScoreBoardView.showScoreForTeamA(teamA.Score);
        mScoreBoardView.showScoreForTeamB(teamB.Score);
        mScoreBoardView.showResetWithToast(message);
    }



    @Override
    public void btnListenerForScoreA(View v) {
        switch (v.getId()) {
            case R.id.teamAbtn1:
                teamA.Score = teamA.Score + _SCORE_4_POINT;
                mScoreBoardView.showScoreForTeamA(teamA.Score);
                break;
            case R.id.teamAbtn2:
                teamA.Score = teamA.Score + _SCORE_1_POINT;
                mScoreBoardView.showScoreForTeamA(teamA.Score);
                break;
            case R.id.teamAbtn3:
                teamA.Score = teamA.Score + _SCORE_3_POINT;
                mScoreBoardView.showScoreForTeamA(teamA.Score);
                break;
            case R.id.teamAbtn4:
                teamA.Score = teamA.Score+ _SCORE_7_POINT;
                mScoreBoardView.showScoreForTeamA(teamA.Score);
                break;
        }

    }


    @Override
    public void btnListnerForScoreB(View v) {
        switch (v.getId()) {
            case R.id.teamBbtn1:
                teamB.Score = teamB.Score + _SCORE_4_POINT;
                mScoreBoardView.showScoreForTeamB(teamB.Score);
                break;
            case R.id.teamBbtn2:
                teamB.Score = teamB.Score + _SCORE_1_POINT;
                mScoreBoardView.showScoreForTeamB(teamB.Score);
                break;
            case R.id.teamBbtn3:
                teamB.Score = teamB.Score + _SCORE_3_POINT;
                mScoreBoardView.showScoreForTeamB(teamB.Score);
                break;
            case R.id.teamBbtn4:
                teamB.Score = teamB.Score+ _SCORE_7_POINT;
                mScoreBoardView.showScoreForTeamB(teamB.Score);
                break;
        }
    }


}
