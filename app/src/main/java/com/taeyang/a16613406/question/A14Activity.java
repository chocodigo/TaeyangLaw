package com.taeyang.a16613406.question;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.taeyang.a16613406.R;
import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by lee on 2018-05-21.
 */

public class A14Activity extends AppCompatActivity{
    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a14);
    }
}
