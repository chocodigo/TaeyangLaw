package com.taeyang.a16613406;

/**
 * Created by lee on 2018-05-03.
 */

public class jobItem {
        private String Title;
        private String subTitle;
        private String Explain;
        private int img;

        jobItem(String Title, String subTitle, int img,String Explain){
            this.Title=Title;
            this.subTitle=subTitle;
            this.Explain=Explain;
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
        public void setExplain(String Explain){this.Explain=Explain;}

        public String getTitle(){
            return Title;
        }
        public String getSubTitle(){
            return subTitle;
        }
        public int getImg(){
            return img;
        }
        public String getExplain() {return Explain;}


}
