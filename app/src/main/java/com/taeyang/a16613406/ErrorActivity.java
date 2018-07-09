package com.taeyang.a16613406;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import tr.xip.errorview.ErrorView;

/**
 * Created by lee on 2018-05-27.
 */


public class ErrorActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        ErrorView errorView = (ErrorView) findViewById(R.id.spErrorView);
        TextView subtitle = (TextView) errorView.findViewById(R.id.ev_subtitle);
        subtitle.setText("1. 공동명의이신 분들은 다른 계약자의 이름으로 로그인 해보세요. \n" +
                "2. 세대 수가 많아 단지를 나눴을 경우가 있습니다. 두 번째 단지를 선택하여 로그인 해보세요.\nex)가온마을 1단지-1, 가온마을 1단지-2" +
                "\n3. 잔금 대출받으신 세대일 경우 아직 은행에서 서류가 이관되기 전일 수 있습니다..\n4. 비대출 세대는 서류를 사무실로 접수해주세요.");
        subtitle.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        subtitle.setLineSpacing(7, 1);

        errorView.setRetryListener(new ErrorView.RetryListener() {
            @Override
            public void onRetry() {
                Intent intent = new Intent(ErrorActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent intent = new Intent(ErrorActivity.this, FirstActivity.class);
                startActivity(intent);
                return false;
            }
        }
        return super.onKeyDown(keyCode,event);
    }
}
