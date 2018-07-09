package com.taeyang.a16613406;

import android.graphics.drawable.Drawable;

/**
 * Created by lee on 2018-04-27.
 */

public class Item {
    private String Title;
    private String subTitle;
    private int img;

    Item(String Title, String subTitle, int img){
        this.Title=Title;
        this.subTitle=subTitle;
        this.img=img;
    }
    public void setTitle(String title){
        this.Title=title;
    }
    public void setSubTitle(String subTitle){
        this.subTitle=subTitle;
    }
    public void setImg(int img){
        this.img=img;
    }

    public String getTitle(){
        return Title;
    }
    public String getSubTitle(){
        return subTitle;
    }
    public int getImg(){
        return img;
    }
}
