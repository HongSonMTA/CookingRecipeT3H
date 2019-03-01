package com.example.thanhson.cookingrecipet3h;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashScreenActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    private LinearLayout linearSplash;
    private Animation alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        linearSplash = findViewById(R.id.linearSplash);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        linearSplash.startAnimation(alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.alpha1_anim, R.anim.alpha_anim);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }
}
