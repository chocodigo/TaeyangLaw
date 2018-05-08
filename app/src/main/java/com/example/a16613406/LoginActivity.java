package com.example.a16613406;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reamhae on 2018-03-07.
 * 어레이 리스트 안된 이유 : 핸들러 안써서(json_parser 안에서 핸들러 호출함)
 */

public class LoginActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener{

    String apt;
    String apt_num;
    String name="";
    String pk1="";
    String pk2="";
    String birth="";

    ArrayList<String> resultArray=new ArrayList<String>();
    ArrayAdapter<String> arrAdapt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final ActionProcessButton button = (ActionProcessButton)findViewById(R.id.login_button);

        final Intent intent=new Intent(LoginActivity.this,MainActivity.class);

        final EditText edit_name=(EditText)findViewById(R.id.Name);
        final EditText edit_pk1=(EditText)findViewById(R.id.pk1);
        final EditText edit_pk2=(EditText)findViewById(R.id.pk2);
        final EditText edit_birth=(EditText)findViewById(R.id.PW);





        new Thread(){
            public void run(){
                StringBuilder html=new StringBuilder();
                String aresult;
                try{
                    URL url=new URL("http://183.100.78.46:8080/get_sheet_info.php");
                    HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.connect();

                    if(conn!=null) {
                        conn.setConnectTimeout(1000);
//                    conn.setUseCaches(false);
                        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
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
        }.start();



        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        name=edit_name.getText().toString();
                        pk1=edit_pk1.getText().toString();
                        pk2=edit_pk2.getText().toString();
                        birth=edit_birth.getText().toString();

                        intent.putExtra("apt",apt_num);
                        intent.putExtra("name",name);
                        intent.putExtra("pk1",pk1);
                        intent.putExtra("pk2",pk2);
                        intent.putExtra("birth",birth);

                        progressGenerator.start(button);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                startActivity(intent);
                            }
                        }, 2000);
                    }
                }
        );

    }
    @Override
    public void onComplete() {

    }

    public void JSON_parser(String b_result){

        try {
            JSONParser jsonParser = new JSONParser();
            System.out.println(b_result);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(b_result);

            long cnt=(long)jsonObject.get("sheetCnt");
            JSONArray ja = (JSONArray) jsonObject.get("apt");

            for(int i=0; i<cnt; i++){
                JSONObject json=(JSONObject)ja.get(i);
                int j=i+1;
                String count=Integer.toString(j);
                apt=json.get(count).toString();
                resultArray.add(apt);
            }
            mAfterDown.sendEmptyMessage(0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    Handler mAfterDown=new Handler(){
        public void handleMessage(Message msg) {
            Spinner spinner = (Spinner)findViewById(R.id.apart_name);
            arrAdapt=new ArrayAdapter(LoginActivity.this, R.layout.custom_simple_dropdown_item_1line, resultArray);

            spinner.setAdapter(arrAdapt);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent,View view, int position, long id){
                    apt_num=Integer.toString(position);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent){}
            });


            //System.out.println(resultArray.get(0).toString());
            /*TextView test=(TextView)findViewById(R.id.test);
            test.setText(resultArray.get(0).toString());*/
        }
    };
}
