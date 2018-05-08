package com.example.a16613406;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lee on 2018-04-30.
 */

public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);

        // set fancy typeface
        tv.setTypeface(Typefaces.get(LoadingActivity.this, "ink_liquid.ttf"));

        // start animation
        new Titanic().start(tv);

        startLoading();
    }

    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(getBaseContext(),FirstActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
