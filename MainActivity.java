package com.example.simpletimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime = 50 * 1000;
    private final long interval = 1000;
    private long millisUntilFinished;

    public void CountDownTimer(long millisInFuture, long countDownInterval) {
        //super(millisInFuture, countDownInterval);
    }


    public MainActivity(MyCountDownTimer countDownTimer) {
        this.countDownTimer = countDownTimer;
        onFinish();
        text.setText("Time's up!");
        timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));

        onTick();
        text.setText("Time remain: " + millisUntilFinished);
        timeElapsed = startTime - millisUntilFinished;
        timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);
        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime));


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!timerHasStarted) {
                    countDownTimer.start();
                    timerHasStarted = true;
                    startB.setText("Start");
                } else {
                    countDownTimer.cancel();
                    timerHasStarted = false;
                    startB.setText("Reset");
                }
            }
        });
    }
}
