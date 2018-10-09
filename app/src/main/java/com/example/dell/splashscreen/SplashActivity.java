package com.example.dell.splashscreen;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView welcomeText;
    private ImageView welcomeImage;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove the status bar or full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash);

        welcomeImage = findViewById(R.id.welcomeImage);
        welcomeText = findViewById(R.id.welcomeText);
        progressBar = findViewById(R.id.progressBar);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_animation);

        welcomeImage.setAnimation(animation);
        welcomeText.setAnimation(animation);

        MyThread myThread = new MyThread();
        myThread.start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {

            for (int i = 1; i <= 5; i++){
                progressBar.setProgress(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }
}
