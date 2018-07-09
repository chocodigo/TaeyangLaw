package com.taeyang.a16613406;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.taeyang.a16613406.R;
import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by lee on 2018-04-04.
 */

public class RefundActivity extends AppCompatActivity{
   String bank_code="";
   String s_bank_name="";
   String account="";
   String refund_money="";
   String param="";
   String name="";
   String apt_name="";
   String pk1="";
   String pk2="";

   Intent n_intent;

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund);

        final Spinner spinner = this.findViewById(R.id.bank_name);
        Button button=this.findViewById(R.id.refund_regist_btn);
        TextView refund_text=this.findViewById(R.id.refund_money_text);
        Intent intent=getIntent();

        n_intent=new Intent(RefundActivity.this,InputActivity.class);

        apt_name=intent.getStringExtra("apt_name");
        pk1=intent.getStringExtra("pk1");
        pk2=intent.getStringExtra("pk2");
        refund_money=intent.getStringExtra("refund_money");
        refund_text.setText(refund_money);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        s_bank_name=spinner.getSelectedItem().toString();
                        switch(s_bank_name){
                            case "농협":
                                bank_code="011";
                                break;
                            case "대구":
                                bank_code="031";
                                break;
                            case "상호저축":
                                bank_code="050";
                                break;
                            case "신협":
                                bank_code="048";
                                break;
                            case "제주":
                                bank_code="035";
                                break;
                            case "경남":
                                bank_code="039";
                                break;
                            case "도이치":
                                bank_code="055";
                                break;
                            case "새마을":
                                bank_code="045";
                                break;
                            case "외환":
                                bank_code="005";
                                break;
                            case "하나":
                                bank_code="081";
                                break;
                            case "광주":
                                bank_code="034";
                                break;
                            case "도쿄":
                                bank_code="059";
                                break;
                            case "우리":
                                bank_code="020";
                                break;
                            case "HSBC":
                                bank_code="054";
                                break;
                            case "국민":
                                bank_code="004";
                                break;
                            case "부산":
                                bank_code="032";
                                break;
                            case "씨티":
                                bank_code="027";
                                break;
                            case "우체국":
                                bank_code="071";
                                break;
                            case "SC제일":
                                bank_code="023";
                                break;
                            case "기업":
                                bank_code="003";
                                break;
                            case "산업":
                                bank_code="002";
                                break;
                            case "신한":
                                bank_code="088";
                                break;
                            case "전북":
                                bank_code="037";
                                break;
                            case "수협":
                                bank_code="007";
                                break;
                            case "기술신용보증기금":
                                bank_code="077";
                                break;
                            case "교보증권":
                                bank_code="261";
                                break;
                            case "대우증권":
                                bank_code="238";
                                break;
                            case "동부증권":
                                bank_code="279";
                                break;
                            case "미즈호코퍼레이드은행":
                                bank_code="058";
                                break;
                            case "메리츠증권":
                                bank_code="287";
                                break;
                            case "수산협동조합":
                                bank_code="007";
                                break;
                            case "신용보증기금":
                                bank_code="076";
                                break;
                            case "신한금융투자":
                                bank_code="278";
                                break;
                            case "에이비엔암로은행":
                                bank_code="056";
                                break;
                            case "우리투자증권":
                                bank_code="247";
                                break;
                            case "유진투자증권":
                                bank_code="280";
                                break;
                            case "투자증권HMC":
                                bank_code="263";
                                break;
                            case "한국투자증권":
                                bank_code="243";
                                break;
                            case "한화증권":
                                bank_code="269";
                                break;
                            case "금융결제원":
                                bank_code="099";
                                break;
                            case "동양종합금융증권":
                                bank_code="209";
                                break;
                            case "대신증권":
                                bank_code="267";
                                break;
                            case "모건스탠리은행":
                                bank_code="052";
                                break;
                            case "미래에셋증권":
                                bank_code="230";
                                break;
                            case "뱅크오브아메리카":
                                bank_code="060";
                                break;
                            case "신용협동조합":
                                bank_code="048";
                                break;
                            case "삼성증권":
                                bank_code="240";
                                break;
                            case "신영증권":
                                bank_code="291";
                                break;
                            case "유에프제이은행":
                                bank_code="057";
                                break;
                            case "SK증권":
                                bank_code="266";
                                break;
                            case "NH투자증권":
                                bank_code="289";
                                break;
                            case "현대증권":
                                bank_code="218";
                                break;
                            case "하이투자증권":
                                bank_code="262";
                                break;
                            case "하나대투증권":
                                bank_code="270";
                                break;
                        }
                        EditText edit_acc=(EditText)findViewById(R.id.account);

                        EditText edit_depositor=(EditText)findViewById(R.id.depositor);

                        account=edit_acc.getText().toString();

                        name=edit_depositor.getText().toString();
                        param="name="+name+"&bank_code="+bank_code+"&account="+account+"&refund_money="+refund_money+"&apt_name="+apt_name+"&pk1="+pk1+"&pk2="+pk2+"";

                        n_intent.putExtra("param",param);
                        startActivity(n_intent);

                    }
                }
        );
    }
}
