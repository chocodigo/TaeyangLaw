package com.taeyang.a16613406;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.taeyang.a16613406.R;
import com.taeyang.a16613406.model.OrderStatus;
import com.taeyang.a16613406.model.Orientation;
import com.taeyang.a16613406.model.TimeLineModel;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    Thread_for_result mThread;

    String result="";
    String param="";
    String get_apt;
    String get_apt_name;
    String get_name;
    String get_pk1;
    String get_pk2;
    String get_birth;
    String get_phone;

    String send_apt_name;
    String send_refund_money;

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();
    private Orientation mOrientation;
    private boolean mWithLinePadding;

    customer person=new customer();

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                return false;
            }
        }
        return super.onKeyDown(keyCode,event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();

        get_apt = intent.getStringExtra("apt");
        get_name = intent.getStringExtra("name");
        get_pk1 = intent.getStringExtra("pk1");
        get_pk2 = intent.getStringExtra("pk2");
        get_birth = intent.getStringExtra("birth");
        get_apt_name=intent.getStringExtra("apt_name");

        System.out.println("받은 아파트 이름 : "+get_apt_name);

        param = "name=" + get_name + "&apt=" + get_apt + "&pk1=" + get_pk1 + "&pk2=" + get_pk2 + "&birth=" + get_birth + "&apt_name=" + get_apt_name + "";

        mOrientation = Orientation.VERTICAL;
        mWithLinePadding = true;

        setTitle(mOrientation == Orientation.HORIZONTAL ? getResources().getString(R.string.horizontal_timeline) : getResources().getString(R.string.vertical_timeline));

        mRecyclerView = (RecyclerView) findViewById(R.id.timelineRecyclerView);
        mRecyclerView.setLayoutManager(getLinearLayoutManager());
        mRecyclerView.setHasFixedSize(true);



        mThread = new Thread_for_result();

        mThread.start();
        try {
            mThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void setDataListItems(int cond){
        String ac_date="";
        if(person.getLoan_bank().equals("없음"))
            mDataList.add(new TimeLineModel("접수 완료 상태입니다.",person.getOffice_date(), OrderStatus.COMPLETED));
        else
            mDataList.add(new TimeLineModel(person.getLoan_bank()+"에서 서류이관받았습니다.",person.getOffice_date(),OrderStatus.COMPLETED));

        switch(cond){
            case 1:
                mDataList.add(new TimeLineModel("검인신청 준비중입니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("취득신고 준비중입니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("소유권 이전등기 비용 산정 전입니다.\n잔금 완납서 수령후 비용 산정 후에 안내 전화 드립니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("취득세 납부 준비중입니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("매도서류 수령 준비중입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기 접수 준비중입니다."+
                        "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기 권리증 완료 전입니다.","",OrderStatus.INACTIVE));
                break;
            case 2:
                mDataList.add(new TimeLineModel("검인신청 완료 되었습니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("취득신고 준비중입니다.","",OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("소유권 이전등기 비용 산정 전입니다.\n잔금 완납서 수령후 비용 산정 후에 안내 전화 드립니다.","",OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("취득세 납부 준비중입니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("매도서류 수령 준비중입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기소 접수 준비중입니다."+
                        "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기 권리증 완료 전입니다.","",OrderStatus.INACTIVE));
                break;
            case 3:
                mDataList.add(new TimeLineModel("검인신청 완료 되었습니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("취득신고 완료 되었습니다.","",OrderStatus.COMPLETED));
                if(person.getIs_deposit().equals("X"))
                    mDataList.add(new TimeLineModel("소유권 이전등기 비용 산정이 완료되었습니다."+
                            "\n취득세는 준공일과 잔금 납부일 중 늦은 날로부터 60일 이내에 납부를 하셔야합니다."+
                            "\n취득세 신고 및 납부를 태양 법률사무소를 통해 진행하시려면 납부기한 2주 전에는 입금하셔야 합니다."+
                            "\n입금하실 금액은 "+person.getReg_money()+" 원 입니다."+
                            "\n입금은행 : "+person.getBank()+
                            "\n계좌번호 :  "+person.getAccount()+
                            "\n계좌명 : "+person.getAccount_name(),"",OrderStatus.ACTIVE));
                else{
                    mDataList.add(new TimeLineModel("등기비용 입금 완료되었습니다."+
                            "\n태양 법률 사무소에서는 취득세 기한이 빠르시고 먼저 입금하신 순서로 납부를 진행해드리고 있습니다."+
                            "\n총 등기비용은 "+person.getReg_money()+" 원 입니다."+
                            "\n실입금액은 "+person.getDeposit_money()+" 원 입니다."
                            ,person.getMoney_send_date(),OrderStatus.COMPLETED));
                }
                mDataList.add(new TimeLineModel("취득세 납부 준비중입니다.",person.getAcquire_date(),OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("매도서류 수령 준비중입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기소 접수 준비중입니다."+
                        "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기 권리증 완료 전입니다.","",OrderStatus.INACTIVE));
                break;
            case 4:
                mDataList.add(new TimeLineModel("검인신청 완료 되었습니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("등기비용 입금 완료되었습니다."+
                        "\n총 등기비용은 "+person.getReg_money()+" 원 입니다."+
                        "\n실입금액은 "+person.getDeposit_money()+" 원 입니다."
                        ,person.getMoney_send_date(),OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("취득신고 완료 되었습니다.","",OrderStatus.COMPLETED));
                if(person.getAcquire_date().equals("감면")) {
                    ac_date = "감면";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("면제")) {
                    ac_date = "면제";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("본인납부")) {
                    ac_date = "본인납부";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("없음")) {
                    ac_date = "없음";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else {
                    ac_date = person.getAcquire_date();
                    mDataList.add(new TimeLineModel("취득세 납부 완료되었습니다.", ac_date, OrderStatus.COMPLETED));
                }
                mDataList.add(new TimeLineModel("매도서류 미수령 상태입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("등기소 접수 준비중입니다."+
                        "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.","",OrderStatus.INACTIVE));
                mDataList.add(new TimeLineModel("등기 권리증 완료 전입니다.","",OrderStatus.INACTIVE));
                break;
            case 5:
                mDataList.add(new TimeLineModel("검인신청 완료 되었습니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("등기비용 입금 완료되었습니다."+
                        "\n총 등기비용은 "+person.getReg_money()+" 원 입니다."+
                        "\n실입금액은 "+person.getDeposit_money()+" 원 입니다."
                        ,person.getMoney_send_date(),OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("취득신고 완료 되었습니다.","",OrderStatus.COMPLETED));
                if(person.getAcquire_date().equals("감면")) {
                    ac_date = "감면";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("면제")) {
                    ac_date = "면제";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("본인납부")) {
                    ac_date = "본인납부";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("없음")) {
                    ac_date = "없음";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else {
                    ac_date = person.getAcquire_date();
                    mDataList.add(new TimeLineModel("취득세 납부 완료되었습니다.", ac_date, OrderStatus.COMPLETED));
                }
                mDataList.add(new TimeLineModel("매도서류 수령완료 상태입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("등기소 접수 준비중입니다."+
                        "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.","",OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("등기 권리증 완료 전입니다.","",OrderStatus.INACTIVE));
                break;
            case 6:
                mDataList.add(new TimeLineModel("검인신청 완료 되었습니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("등기비용 입금 완료되었습니다."+
                        "\n총 등기비용은 "+person.getReg_money()+" 원 입니다."+
                        "\n실입금액은 "+person.getDeposit_money()+" 원 입니다."
                        ,person.getMoney_send_date(),OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("취득신고 완료 되었습니다.","",OrderStatus.COMPLETED));
                if(person.getAcquire_date().equals("감면")) {
                    ac_date = "감면";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("면제")) {
                    ac_date = "면제";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("본인납부")) {
                    ac_date = "본인납부";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("없음")) {
                    ac_date = "없음";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else {
                    ac_date = person.getAcquire_date();
                    mDataList.add(new TimeLineModel("취득세 납부 완료되었습니다.", ac_date, OrderStatus.COMPLETED));
                }
                mDataList.add(new TimeLineModel("매도서류 수령완료 상태입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.COMPLETED));
                if(person.getReg_date().equals("0"))
                    mDataList.add(new TimeLineModel("등기소 접수 준비중입니다."+
                            "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.","",OrderStatus.ACTIVE));
                else
                    mDataList.add(new TimeLineModel("등기가 접수 되었습니다."+
                            "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.",person.getReg_date(),OrderStatus.ACTIVE));
                mDataList.add(new TimeLineModel("등기 권리증 완료 전입니다.","",OrderStatus.INACTIVE));
                break;
            case 7:
                mDataList.add(new TimeLineModel("검인신청 완료 되었습니다.\n해당 시청, 구청에서 처리됩니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("등기비용 입금 완료되었습니다."+
                        "\n총 등기비용은 "+person.getReg_money()+" 원 입니다."+
                        "\n실입금액은 "+person.getDeposit_money()+" 원 입니다."
                        ,person.getMoney_send_date(),OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("취득신고 완료 되었습니다.","",OrderStatus.COMPLETED));
                if(person.getAcquire_date().equals("감면")) {
                    ac_date = "감면된 상태입니다.";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("면제")) {
                    ac_date = "면제된 상태입니다.";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("본인납부")) {
                    ac_date = "본인납부";
                    mDataList.add(new TimeLineModel(ac_date+"\n취득세 납부 완료되었습니다.","",OrderStatus.COMPLETED));
                }
                else if(person.getAcquire_date().equals("없음")) {
                    ac_date = "면제된 상태입니다.";
                    mDataList.add(new TimeLineModel(ac_date,"",OrderStatus.COMPLETED));
                }
                else {
                    ac_date = person.getAcquire_date();
                    mDataList.add(new TimeLineModel("취득세 납부 완료되었습니다.", ac_date, OrderStatus.COMPLETED));
                }
                mDataList.add(new TimeLineModel("매도서류 수령완료 상태입니다."+
                        "\n매도서류는 보존등기가 나온 후 신청할 수 있습니다."+
                        "\n* 보존등기 : 등기상 소유자가 없던 부동산에 최초로 소유자 등기를 하는 것(출생신고와 동일한 개념)"+
                        "\n* 보존등기는 시행사에서 진행하며 매도서류도 시행사에 신청합니다.","",OrderStatus.COMPLETED));
                mDataList.add(new TimeLineModel("등기가 접수 되었습니다."+
                        "\n등기 처리는 등기소에서 진행하는 것이며 통상 2,3주 걸립니다.",person.getReg_date(),OrderStatus.COMPLETED));
                if(!person.getIs_text().equals("문자")){
                    mDataList.add(new TimeLineModel("등기 권리증이 완료되었습니다."
                            + "\n현재 등기권리증과 필요 서류들을 취합 중에 있습니다."
                            + "\n완료 후 안내 문자 발송 예정입니다.", person.getReg_complete_date(), OrderStatus.ACTIVE));
                }
                else {
                    mDataList.add(new TimeLineModel("등기 권리증이 완료되었습니다."
                            + "\n등기 권리증은 빠른 등기 우편으로 발송되며 받아보실 주소에 사람이 계시지 않으면 반송처리될 수 있습니다."
                            + "\n환급금은 매주 수요일에 처리가 됩니다.", person.getReg_complete_date(), OrderStatus.ACTIVE));
                }
                break;
        }
    }

    private LinearLayoutManager getLinearLayoutManager() {
        if (mOrientation == Orientation.HORIZONTAL) {
            return new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        } else {
            return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        }
    }

    private void initView(int cond) {
        setDataListItems(cond);
        mTimeLineAdapter = new TimeLineAdapter(mDataList, mOrientation, mWithLinePadding, MainActivity.this);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    Handler mAfterDown=new Handler(){

        public void handleMessage(Message msg){
            TextView person_pk1=(TextView)findViewById(R.id.person_pk1);
            TextView person_pk2=(TextView)findViewById(R.id.person_pk2);
            TextView person_apt=(TextView)findViewById(R.id.person_apt);
            TextView person_name=(TextView)findViewById(R.id.person_name);

            if(msg.what==0){
                Intent error=new Intent(MainActivity.this,ErrorActivity.class);
                startActivity(error);
                //finish();
            }
            else {
                person_pk1.setText(person.getPk1());
                person_pk2.setText(person.getPk2());
                person_apt.setText(person.getApt());
                if (!person.getName2().equals("0")) {
                    person_name.setText(person.get_Name() + "\n" + person.getName2());
                } else
                    person_name.setText(person.get_Name());
                initView(msg.what);
                switch (msg.what) {
                    //입력정보가 없을때 출력
                    //등기 완료
                    case 7:

                        if (person.getReg_send_date().equals("0")&&person.getIs_text().equals("문자")) {
                            Button reg_button = (Button) findViewById(R.id.btn_reg);
                            reg_button.setVisibility(View.VISIBLE);
                            reg_button.setOnClickListener(
                                    new Button.OnClickListener() {
                                        public void onClick(View v) {

                                            final Intent next_intent = new Intent(MainActivity.this, RegistActivity.class);
                                            next_intent.putExtra("apt_name", person.getApt());
                                            next_intent.putExtra("pk1", person.getPk1());
                                            next_intent.putExtra("pk2", person.getPk2());
                                            next_intent.putExtra("name", person.get_Name());
                                            next_intent.putExtra("phone", person.getPhone());
                                            startActivity(next_intent);
                                        }
                                    }
                            );
                        }
                        if ((Integer.parseInt(person.getRefund_money()) > 0) && person.getIs_text().equals("문자")) {
                            Button button = (Button) findViewById(R.id.btn_refund);
                            button.setVisibility(View.VISIBLE);
                            button.setOnClickListener(
                                    new Button.OnClickListener() {
                                        public void onClick(View v) {
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
        }
    };



    private class Thread_for_result extends Thread{
        String addr="http://183.100.142.142:8080/test.php";
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
            person.setDeposit_money(json.get("deposit_money").toString());
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
            person.setIs_text(json.get("is_text").toString());

            //검인신청이 준비중이면 출력
            if(person.getIs_seal().equals("준비중")){
                mAfterDown.sendEmptyMessage(1);
            }
            //취득신고가 준비중, 검인신청이 완료이면 출력
            else if(person.getIs_acquire().equals("준비중")&&person.getIs_seal().equals("완료")){
                mAfterDown.sendEmptyMessage(2);
            }
            //취득신고 완료-> 취득세납부 준비중
            else if(person.getAcquire_date().equals("0")&&person.getIs_acquire().equals("신고후")){
                mAfterDown.sendEmptyMessage(3);
            }
            //매도서류 미수령, 취득세 납부완료
            else if(person.getIs_get_sell().equals("미수령")&&!person.getAcquire_date().equals("0")){
                mAfterDown.sendEmptyMessage(4);
            }
            //매도서류 수령, 취득세 납부완료
            else if(person.getIs_get_sell().equals("서류수령")&&!person.getAcquire_date().equals("0")&&person.getReg_complete_date().equals("0")){
                mAfterDown.sendEmptyMessage(5);
            }
            //등기접수
            else if(!person.getIs_get_sell().equals("서류수령")&&!person.getReg_date().equals("0")&&person.getReg_complete_date().equals("0"))
                mAfterDown.sendEmptyMessage(6);
            //등기 완료
            else if(!person.getReg_complete_date().equals("0"))
                mAfterDown.sendEmptyMessage(7);
        }catch(Exception e){
            mAfterDown.sendEmptyMessage(0);
            e.printStackTrace();

        }
    }

}


