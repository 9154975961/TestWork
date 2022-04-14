package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    long timeSec;
    CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.rl);

        final TextView textView = (TextView) findViewById(R.id.tv1);

        mainLayout.setOnTouchListener(new View.OnTouchListener(){
        @SuppressLint("ClickableViewAccessibility")
        @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

            timeSec = 5000;

            if (timer!=null){
                timer.cancel();
                timer.start();
            } else {
            timer = new CountDownTimer(timeSec,1000) {

                @Override
                public void onTick(long l) {
                    timeSec = l;

                }

                @Override
                public void onFinish() {
                    textView.animate().translationY(2150).setDuration(1500).start();
                }
            }.start();}

                    float X = motionEvent.getX();
                    float Y = motionEvent.getY();

            Spannable spans = new SpannableString("HELLO ПРИВЕТ");
            spans.setSpan(new ForegroundColorSpan(Color.BLUE), 0, spans.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spans.setSpan(new ForegroundColorSpan(Color.RED), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(spans);


                textView.animate().translationX(X).setDuration(0).start();
                textView.animate().translationY(Y).setDuration(0).start();

                if (X>0&&X<50) textView.animate().translationX(900).setDuration(1500).start();

                if (X>900) textView.animate().translationX(0).setDuration(1500).start();

                if (Y>0&&Y<50) textView.animate().translationY(2150).setDuration(1500).start();

                if (Y>2150) textView.animate().translationY(0).setDuration(1500).start();


            /*DisplayMetrics new = DisplayMetrics DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(DisplayMetrics);
            DisplayMetrics = height int.heightPixels;
            DisplayMetrics = width int.widthPixels;*/ // узнать высоту и ширину экрана

            /*textView.animate().translationX(a).setDuration(500).start();
            textView.animate().translationY(b).setDuration(500).start();*/ //анимированное перемещение
            return false;
             }
        });


}
}