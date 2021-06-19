package com.harsh.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText t1;
    TextView textresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void timer(View view)
    {
        t1=findViewById(R.id.time);
        textresult=findViewById(R.id.textresult);
        int n=Integer.parseInt(String.valueOf((t1.getText())));
        int min=n*60000;
        new CountDownTimer(min,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                String str=f.format(hour) + ":" + f.format(min) + ":" + f.format(sec);
                textresult.setText(str);

            }
            @Override
            public void onFinish() {
                textresult.setText("00:00:00\n\n!! Finished !!");
            }
        }.start();
    }
    public void playSoundFile(Integer fileName){
        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(this, fileName);
        mediaPlayer.start();
    }
}