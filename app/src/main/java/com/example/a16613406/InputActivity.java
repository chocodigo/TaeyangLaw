package com.example.a16613406;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lee on 2018-04-05.
 */

public class InputActivity extends AppCompatActivity {
    String param="";
    String addr="http://183.100.78.46:8080/refund.php";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent intent=getIntent();

        param=intent.getStringExtra("param");

        new Thread(){
            public void run(){
                try{
                    URL url=new URL(addr);
                    HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.connect();

                    OutputStream outs = conn.getOutputStream();
                    outs.write(param.getBytes("UTF-8"));
                    outs.flush();
                    outs.close();

                    if(conn!=null) {
                        conn.setConnectTimeout(1000);
//                    conn.setUseCaches(false);
                        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                        }
                        conn.disconnect();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        Button button=(Button)findViewById(R.id.back_button);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent_home=new Intent(InputActivity.this, FirstActivity.class);
                        intent_home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent_home.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent_home);
                    }
                }
        );
    }


}
