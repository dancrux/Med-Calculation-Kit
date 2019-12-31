package com.wordpress.cruxonlinedotblog.cruxbmicalc.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

public class SplashActivity extends AppCompatActivity {
private static boolean splashLoaded = false;
protected boolean _active = true;
protected int _splashTime= 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "202986230", true);
        StartAppAd.showSplash(this, savedInstanceState,

                new SplashConfig()
                        .setTheme(SplashConfig.Theme.USER_DEFINED)
                        .setCustomScreen(R.layout.activity_splash)
        );

//        setContentView(R.layout.activity_splash);
        Thread splashThread = new Thread(){
            public void run(){
                try{
                    int waited = 0;
                    while (_active && (waited< _splashTime)){
                        sleep(100);
                        if (_active){
                            waited += 100;

                        }
                    }

                }catch(Exception e){

                }finally {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }

            }
        };
        splashThread.start();


    }
}
