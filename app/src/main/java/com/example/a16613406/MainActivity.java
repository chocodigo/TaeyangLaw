package com.example.a16613406;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class MainActivity extends AppCompatActivity {
    Thread_for_result mThread;

    String result="";
    String param="";
    String get_apt;
    String get_name;
    String get_pk1;
    String get_pk2;
    String get_birth;
    String get_phone;

    String send_apt_name;
    String send_refund_money;

    customer person=new customer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();

        get_apt=intent.getStringExtra("apt");
        get_name=intent.getStringExtra("name");
        get_pk1= intent.getStringExtra("pk1");
        get_pk2=intent.getStringExtra("pk2");
        get_birth=intent.getStringExtra("birth");

        param="name="+get_name+"&apt="+get_apt+"&pk1="+get_pk1+"&pk2="+get_pk2+"&birth="+get_birth+"";

        mThread=new Thread_for_result();

        mThread.start();
        try{
            mThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    Handler mAfterDown=new Handler(){

        public void handleMessage(Message msg){
            TextView person_text=(TextView)findViewById(R.id.person_explain);
            TextView person_pk1=(TextView)findViewById(R.id.person_pk1);
            TextView person_pk2=(TextView)findViewById(R.id.person_pk2);
            TextView person_apt=(TextView)findViewById(R.id.person_apt);
            TextView person_name=(TextView)findViewById(R.id.person_name);


            switch(msg.what){
                //입력정보가 없을때 출력
                case 0:
                    Toast.makeText(MainActivity.this,"입력한 정보가 존재하지 않습니다.",Toast.LENGTH_LONG).show();
                    break;
                //검인신청이 준비중이면 출력
                case 1:
                    person_pk1.setText(person.getPk1());
                    person_pk2.setText(person.getPk2());
                    person_apt.setText(person.getApt());
                    if(!person.getName2().equals("0")){
                        person_name.setText(person.get_Name()+"\n"+person.getName2());
                    }
                    else
                        person_name.setText(person.get_Name());
                    person_text.setText("고객님의 서류는 "+person.getOffice_date()+" 에 사무실로 이관해왔습니다." +
                            "\n현재 검인신청은 "+person.getIs_seal()+"상태입니다.");
                    break;
                //취득신고가 준비중이면 출력
                case 2:
                    person_pk1.setText(person.getPk1());
                    person_pk2.setText(person.getPk2());
                    person_apt.setText(person.getApt());
                    if(!person.getName2().equals("0")){
                        person_name.setText(person.get_Name()+"\n"+person.getName2());
                    }
                    else
                        person_name.setText(person.get_Name());
                    person_text.setText("고객님의 서류는 "+person.getOffice_date()+" 에 사무실로 이관해왔습니다." +
                            "\n현재 검인신청은 "+person.getIs_seal()+"상태입니다." +
                            "\n현재 취득세는 "+person.getIs_acquire()+"상태입니다.");
                    break;
                //매도서류가 미수령이거나 등기접수가 되지않았으면 출력
                case 3:
                    person_pk1.setText(person.getPk1());
                    person_pk2.setText(person.getPk2());
                    person_apt.setText(person.getApt());
                    if(!person.getName2().equals("0")){
                        person_name.setText(person.get_Name()+"\n"+person.getName2());
                    }
                    else
                        person_name.setText(person.get_Name());
                    person_text.setText("고객님의 서류는 "+person.getOffice_date()+" 에 사무실로 이관해왔습니다." +
                            "\n현재 검인신청은 "+person.getIs_seal()+"상태입니다." +
                            "\n현재 취득세는 "+person.getIs_acquire()+"상태입니다."+
                            "\n취득세는 "+person.getAcquire_date()+"에 납부되었습니다."+
                            "\n총 등기비용은 "+person.getReg_money()+"원 입니다."+
                            "\n현재 매도서류는 "+person.getIs_get_sell()+"상태입니다.");
                    break;
                // 등기 완료가 되었으면 출력
                case 4:
                    person_pk1.setText(person.getPk1());
                    person_pk2.setText(person.getPk2());
                    person_apt.setText(person.getApt());
                    if(!person.getName2().equals("0")){
                        person_name.setText(person.get_Name()+"\n"+person.getName2());
                    }
                    else
                        person_name.setText(person.get_Name());
                    person_text.setText("고객님의 서류는 "+person.getOffice_date()+" 에 사무실로 이관해왔습니다." +
                            "\n현재 검인신청은 "+person.getIs_seal()+"상태입니다." +
                            "\n현재 취득세는 "+person.getIs_acquire()+"상태입니다."+
                            "\n취득세는 "+person.getAcquire_date()+"에 납부되었습니다."+
                            "\n총 등기비용은 "+person.getReg_money()+"원 입니다."+
                            "\n현재 매도서류는 "+person.getIs_get_sell()+"상태입니다."+
                            "\n등기소 접수일은 "+person.getReg_date()+"입니다."+
                            "\n등기 완료일은 "+person.getReg_complete_date()+"입니다."+
                            "\n등기권리증 발송일자는 "+person.getReg_send_date()+"입니다."
                    );
                    if(person.getReg_send_date().equals("0"))
                    {
                        Button reg_button=(Button)findViewById(R.id.btn_reg);
                        reg_button.setVisibility(View.VISIBLE);
                        reg_button.setOnClickListener(
                                new Button.OnClickListener(){
                                    public void onClick(View v){

                                        final Intent next_intent=new Intent(MainActivity.this,RegistActivity.class);
                                        next_intent.putExtra("apt_name",person.getApt());
                                        next_intent.putExtra("pk1",person.getPk1());
                                        next_intent.putExtra("pk2",person.getPk2());
                                        next_intent.putExtra("name",person.get_Name());
                                        next_intent.putExtra("phone",person.getPhone());
                                        startActivity(next_intent);
                                    }
                                }
                        );
                    }
                    if(Integer.parseInt(person.getRefund_money())>0){
                        Button button=(Button)findViewById(R.id.btn_refund);
                        button.setVisibility(View.VISIBLE);
                        button.setOnClickListener(
                                new Button.OnClickListener(){
                                    public void onClick(View v){
                                            final Intent next_intent = new Intent(MainActivity.this, RefundActivity.class);
                                            next_intent.putExtra("apt_name", person.getApt());
                                            next_intent.putExtra("pk1", person.getPk1());
                                            next_intent.putExtra("pk2", person.getPk2());
                                            next_intent.putExtra("refund_money", person.getRefund_money());
                                            startActivity(next_intent);


                                    }
                                }
                        );
                    }
                    break;

            }

        }
    };



    private class Thread_for_result extends Thread{
        String addr="http://183.100.78.46:8080/test.php";
        String aresult;

        @Override
        public void run(){

            StringBuilder html=new StringBuilder();
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

                if(conn!=null){
                    conn.setConnectTimeout(1000);
//                    conn.setUseCaches(false);
                    if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                        BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        for( ; ; ){
                            String line=br.readLine();
                            if(line==null)break;
                            html.append(line+'\n');
                        }
                        br.close();
                        aresult=html.toString();
                        JSON_parser(aresult);

                    }
                    conn.disconnect();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public void JSON_parser(String b_result){

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(b_result);
            JSONObject json = (JSONObject) jsonObject.get("person");

            if(json==null){
                mAfterDown.sendEmptyMessage(0);
                finish();
            }

            person.setYear_num(json.get("year_num").toString());
            person.setNum(json.get("num").toString());
            person.setApt(json.get("apt").toString());
            person.setPk1(json.get("pk1").toString());
            person.setPk2(json.get("pk2").toString());
            person.set_Name(json.get("name").toString());
            if(json.get("name2").toString()!=null)
                person.setName2(json.get("name2").toString());
            person.setPhone(json.get("phone").toString());
            person.setOffice_date(json.get("office_date").toString());
            person.setIs_seal(json.get("is_seal").toString());
            person.setAcquire_date(json.get("acquire_date").toString());
            person.setReg_money(json.get("reg_money").toString());
            person.setMoney_send_date(json.get("money_send_date").toString());
            person.setIs_get_sell(json.get("is_get_sell").toString());
//            person.setDeposit_money(json.get("deposit_money").toString());
            person.setReg_date(json.get("reg_date").toString());
            person.setReg_complete_date(json.get("reg_complete_date").toString());
            person.setReg_send_date(json.get("reg_send_date").toString());
            person.setBank(json.get("bank").toString());
            person.setAccount(json.get("account").toString());
            person.setAccount_name(json.get("account_name").toString());
            person.setIs_deposit(json.get("is_deposit").toString());
            person.setLoan_bank(json.get("loan_bank").toString());
            person.setRefund_money(json.get("refund_money").toString());
            person.setRefund_date(json.get("refund_date").toString());
            person.setIs_acquire(json.get("is_acquire").toString());

            //검인신청이 준비중이면 출력
            if(person.getIs_seal().equals("준비중")){
                mAfterDown.sendEmptyMessage(1);
            }
            //취득신고가 준비중이면 출력
            else if(person.getIs_acquire().equals("준비중")){
                mAfterDown.sendEmptyMessage(2);
            }
            //매도서류가 미수령이거나 등기접수가 안됐으면 출력
            else if(person.getIs_get_sell().equals("미수령")||person.getReg_date().equals("0")){
                mAfterDown.sendEmptyMessage(3);
            }
            // 등기 완료가 되었으면 출력
            else if(!person.getReg_complete_date().equals("0")){
                mAfterDown.sendEmptyMessage(4);
            }
        }catch(Exception e){
            e.printStackTrace();

        }
    }

}


