package com.taeyang.a16613406;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.tsengvn.typekit.Typekit;

/**
 * Created by lee on 2018-05-17.
 */

public class ApplicationBase extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this,"NanumGothic.ttf"))
                .addBold(Typekit.createFromAsset(this,"NanumGothicExtraBold.ttf"));
    }
}
