package com.muhsantech.alertdialogbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.muhsantech.alertdialogbox.databinding.ActivitySplashScreenBinding;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Objects.requireNonNull(getSupportActionBar()).hide();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                }catch (Exception e){e.printStackTrace();}finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();


    }
}