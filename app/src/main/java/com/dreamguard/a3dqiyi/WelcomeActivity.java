package com.dreamguard.a3dqiyi;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {


    private CountDownTimer mCountDownTimer = new CountDownTimer(3100, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            Log.d("dai","millisUntilFinished:"+millisUntilFinished);
            if (!isFinishing()) {
                welcomeText.setText((millisUntilFinished / 1000) + "跳过");
            }
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent();
            intent.setClass(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        mCountDownTimer.start();
    }

    public void initView() {
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        welcomeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.welcome_text:
                cacelTimer();
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void cacelTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }

    @Override
    protected void onDestroy() {
        cacelTimer();
        super.onDestroy();
    }
}
