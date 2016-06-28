package mx.yellowme.myapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.yellowme.util.Util;

public class SplashActivity extends AppCompatActivity {

    private MyappApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        app = (MyappApplication) getApplicationContext();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(app.isLoginStart()){
                    Util.sendAndFinish(SplashActivity.this, MainActivity.class);
                }else{
                    Util.sendAndFinish(SplashActivity.this, LoginActivity.class);
                }
            }
        }, 5000);
    }
}
