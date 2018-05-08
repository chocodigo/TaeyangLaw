package com.example.a16613406;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lee on 2018-04-16.
 */

public class SearchAddressActivity extends AppCompatActivity {
    private WebView webView;
    private TextView result;
    private Handler handler;

    String zonecode;
    String address;
    String building;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);

        init_webView();

        handler=new Handler();

    }

    public void init_webView(){
        webView=(WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.addJavascriptInterface(new AndroidBridge(),"a16613406");
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://183.100.78.46:8080/address.php");
    }

    private class AndroidBridge{
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3){
            handler.post(new Runnable(){
               @Override
                public void run(){
                   //우편번호, 지번주소, 건물이름
                   Intent b_intent=new Intent(SearchAddressActivity.this,RegistActivity.class);

                   b_intent.putExtra("zonecode",arg1);
                   b_intent.putExtra("Address",arg2);
                   b_intent.putExtra("buildingName",arg3);

                   setResult(RESULT_OK,b_intent);
                   finish();
               }
            });
        }
    }
}
