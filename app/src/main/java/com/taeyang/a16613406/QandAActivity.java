package com.taeyang.a16613406;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.taeyang.a16613406.R;
import com.taeyang.a16613406.question.A01Activity;
import com.taeyang.a16613406.question.A02Activity;
import com.taeyang.a16613406.question.A03Activity;
import com.taeyang.a16613406.question.A04Activity;
import com.taeyang.a16613406.question.A05Activity;
import com.taeyang.a16613406.question.A06Activity;
import com.taeyang.a16613406.question.A07Activity;
import com.taeyang.a16613406.question.A08Activity;
import com.taeyang.a16613406.question.A09Activity;
import com.taeyang.a16613406.question.A10Activity;
import com.taeyang.a16613406.question.A11Activity;
import com.taeyang.a16613406.question.A12Activity;
import com.taeyang.a16613406.question.A13Activity;
import com.taeyang.a16613406.question.A14Activity;
import com.taeyang.a16613406.question.A15Activity;
import com.taeyang.a16613406.question.A16Activity;
import com.taeyang.a16613406.question.A17Activity;
import com.taeyang.a16613406.question.A18Activity;


import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;

/**
 * Created by lee on 2018-04-23.
 */

public class QandAActivity extends ApplyActivity {
    private ListView listView;
    ArrayList<String> mDatas=new ArrayList<String>();

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);

        mDatas.add("01. 등기진행 접수 및 방법");
        mDatas.add("02. 소유권이전등기 및 대출 진행과정");
        mDatas.add("03. 소유권이전등기 필요서류");
        mDatas.add("04. 분양권 명의변경 절차");
        mDatas.add("05. 부부 공동명의 신청방법");
        mDatas.add("06. 대출 및 등기서류 접수");
        mDatas.add("07. 잔금조회 및 납부(대출신청세대는 신청한 은행에서 일괄안내)");
        mDatas.add("08. 인수증 발급");
        mDatas.add("09. 열쇠(key) 인수");
        mDatas.add("10. 등록 및 신고 사항");
        mDatas.add("11. 취득세 납부는 언제해야 하나요?");
        mDatas.add("12. 취득세고지서 발급과 납부 방법은?");
        mDatas.add("13. 소유권이전등기 접수 기한은?");
        mDatas.add("14. 보존등기란?");
        mDatas.add("15. 소유권이전등기 절차/소요시간/필요서류는?");
        mDatas.add("16. 공동명의로 명의변경(권리의무승계)은 언제? 장점은?");
        mDatas.add("17. 사용승인(준공)이란?");
        mDatas.add("18. 소유권 보존등기란?");

        qa_adapter adapter=new qa_adapter(this,mDatas);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(listner);
    }

    AdapterView.OnItemClickListener listner=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch(i){
                case 0:
                    Intent intent0=new Intent(QandAActivity.this,A01Activity.class);
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1=new Intent(QandAActivity.this,A02Activity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2=new Intent(QandAActivity.this,A03Activity.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3=new Intent(QandAActivity.this,A04Activity.class);
                    startActivity(intent3);
                    break;
                case 4:
                    Intent intent4=new Intent(QandAActivity.this,A05Activity.class);
                    startActivity(intent4);
                    break;
                case 5:
                    Intent intent5=new Intent(QandAActivity.this,A06Activity.class);
                    startActivity(intent5);
                    break;
                case 6:
                    Intent intent6=new Intent(QandAActivity.this,A07Activity.class);
                    startActivity(intent6);
                    break;
                case 7:
                    Intent intent7=new Intent(QandAActivity.this,A08Activity.class);
                    startActivity(intent7);
                    break;
                case 8:
                    Intent intent8=new Intent(QandAActivity.this,A09Activity.class);
                    startActivity(intent8);
                    break;
                case 9:
                    Intent intent9=new Intent(QandAActivity.this,A10Activity.class);
                    startActivity(intent9);
                    break;
                case 10:
                    Intent intent10=new Intent(QandAActivity.this,A11Activity.class);
                    startActivity(intent10);
                    break;
                case 11:
                    Intent intent11=new Intent(QandAActivity.this,A12Activity.class);
                    startActivity(intent11);
                    break;
                case 12:
                    Intent intent12=new Intent(QandAActivity.this,A13Activity.class);
                    startActivity(intent12);
                    break;
                case 13:
                    Intent intent13=new Intent(QandAActivity.this,A14Activity.class);
                    startActivity(intent13);
                    break;
                case 14:
                    Intent intent14=new Intent(QandAActivity.this,A15Activity.class);
                    startActivity(intent14);
                    break;
                case 15:
                    Intent intent15=new Intent(QandAActivity.this,A16Activity.class);
                    startActivity(intent15);
                    break;
                case 16:
                    Intent intent16=new Intent(QandAActivity.this,A17Activity.class);
                    startActivity(intent16);
                    break;
                case 17:
                    Intent intent17=new Intent(QandAActivity.this,A18Activity.class);
                    startActivity(intent17);
                    break;
            }
        }
    };
}
