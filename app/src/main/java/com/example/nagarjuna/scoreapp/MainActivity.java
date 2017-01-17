package com.example.nagarjuna.scoreapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagarjuna.scoreapp.contract.scoreBoardContract;
import com.example.nagarjuna.scoreapp.presenter.ScoreBoardPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.squareup.haha.guava.base.Joiner.checkNotNull;

public class MainActivity extends AppCompatActivity implements scoreBoardContract.View{

    private ScoreBoardPresenter mScoreBoardPresenter;

    @BindView(R.id.reset) Button resetbtn;
    @BindView(R.id.teamAScore) TextView teamAScore;
    @BindView(R.id.teamBScore) TextView teamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureLayout();
    }

    @Override
    public void configureLayout() {
        setContentView(R.layout.activity_main);
        mScoreBoardPresenter = new ScoreBoardPresenter(this);
        ButterKnife.bind(this);
    }

    @Override
    public void setPresenter(scoreBoardContract.Presenter presenter) {
        mScoreBoardPresenter = (ScoreBoardPresenter) checkNotNull(presenter);
    }


    @OnClick({R.id.teamAbtn1,R.id.teamAbtn2,R.id.teamAbtn3,R.id.teamAbtn4})
    public void configureBtnForScoreA(View v){
        mScoreBoardPresenter.btnListenerForScoreA(v);
    }

    @OnClick({R.id.teamBbtn1,R.id.teamBbtn2,R.id.teamBbtn3,R.id.teamBbtn4})
    public void configureBtnForScoreB(View v){
        mScoreBoardPresenter.btnListnerForScoreB(v);
    }

    @OnClick(R.id.reset)
    public void configureResetButton(View v){
        mScoreBoardPresenter.resetWithToast(v);
    }
    @Override
    public void showResetWithToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showScoreForTeamA(Integer score) {
        teamAScore.setText(String.valueOf(score));
    }

    @Override
    public void showScoreForTeamB(Integer score) {
        teamBScore.setText(String.valueOf(score));
    }


}
