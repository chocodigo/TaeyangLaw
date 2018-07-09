package com.taeyang.a16613406;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.taeyang.a16613406.R;
import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by lee on 2018-04-16.
 */

public class RegistActivity extends AppCompatActivity {
    String apt_name;
    String pk1;
    String pk2;
    String name;
    String phone;

    String zonecode;
    String address;
    String buildingName;

    String allAddress;
    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        Intent intent = getIntent();
        final Intent n_intent=new Intent(RegistActivity.this,SearchAddressActivity.class);

        apt_name=intent.getStringExtra("apt_name");
        pk1=intent.getStringExtra("pk1");
        pk2=intent.getStringExtra("pk2");
        name=intent.getStringExtra("name");
        phone=intent.getStringExtra("phone");

        TextView text_apt=findViewById(R.id.text_apt_name);
        TextView text_pk1=findViewById(R.id.text_pk1);
        TextView text_pk2=findViewById(R.id.text_pk2);
        TextView text_name=findViewById(R.id.text_name);
        TextView text_phone=findViewById(R.id.text_phone);

        text_apt.setText(apt_name);
        text_pk1.setText(pk1);
        text_pk2.setText(pk2);
        text_name.setText(name);
        text_phone.setText(phone);

        Button button=findViewById(R.id.btn_addr_search);
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivityForResult(n_intent,0);
                    }
                }
        );

        Button send_button=findViewById(R.id.btn_apply);
        send_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent a_intent=new Intent(RegistActivity.this,ApplyActivity.class);
                        EditText editText=(EditText)findViewById(R.id.edit_addr);
                        String extraAddress=editText.getText().toString();

                        String param="apt_name="+apt_name+"&pk1="+pk1+"&pk2="+pk2+"&name="+name+"&phone="+phone+"&zonecode="+zonecode+"&address="+address+"&extraAddress="+extraAddress+"&building="+buildingName+"";
                        a_intent.putExtra("param",param);
                        startActivity(a_intent);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==Activity.RESULT_OK){

            zonecode=data.getStringExtra("zonecode");
            address=data.getStringExtra("Address");
            buildingName=data.getStringExtra("buildingName");
            TextView text_address=(TextView)findViewById(R.id.text_addr);


            text_address.setText("("+zonecode+")"+address+" "+buildingName+" ");

            Button button=findViewById(R.id.btn_apply);
            button.setVisibility(View.VISIBLE);

        }
    }
}
