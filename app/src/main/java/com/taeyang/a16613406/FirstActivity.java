package com.taeyang.a16613406;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.View;

import android.widget.Toast;

import com.taeyang.a16613406.R;
import com.tsengvn.typekit.TypekitContextWrapper;


/**
 * Created by lee on 2018-04-17.
 */

public class FirstActivity extends AppCompatActivity {
    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        CardView case0=(CardView)findViewById(R.id.lawyer);
        CardView case1=(CardView)findViewById(R.id.job);
        CardView case2=(CardView)findViewById(R.id.search);
        CardView case3=(CardView)findViewById(R.id.qa);
        CardView case4=(CardView)findViewById(R.id.map);
        CardView case5=(CardView)findViewById(R.id.setting);
        CardView case6=(CardView)findViewById(R.id.phone);
        CardView case7=(CardView)findViewById(R.id.homepage);

        case0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent0=new Intent(FirstActivity.this,IntroduceActivity.class);
                startActivity(intent0);
            }
        });

        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(FirstActivity.this,JobActivity.class);
                startActivity(intent1);
            }
        });

        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(FirstActivity.this,LoginActivity.class);
                startActivity(intent2);
            }
        });

        case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(FirstActivity.this,QandAActivity.class);
                startActivity(intent3);
            }
        });

        case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(FirstActivity.this,MapActivity.class);
                startActivity(intent4);
            }
        });

        case5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(Intent.ACTION_VIEW);
                try {
                    intent5.setData(Uri.parse("market://details?id=lee.taeyang.lee.apt_check"));
                }catch (android.content.ActivityNotFoundException anfe){
                    intent5.setData(Uri.parse("https://play.google.com/store/apps/details?id=lee.taeyang.lee.apt_check"));
                }
                startActivity(intent5);
            }
        });

        case6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE);
                    if(permissionResult== PackageManager.PERMISSION_DENIED){
                        if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                            AlertDialog.Builder dialog=new AlertDialog.Builder(FirstActivity.this);
                            dialog.setTitle("권한이 필요합니다.")
                                    .setMessage("이 기능을 사용하기 위해서는 단말기의 \"전화걸기\" 권한이 필요합니다. 계속하시겠습니까?")
                                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
                                            }
                                        }
                                    })
                                    .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(FirstActivity.this,"기능을 취소했습니다.",Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .create().show();;
                        }
                        else{
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
                        }
                    }
                    else{
                        Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:1661-3406"));
                        startActivity(intent);
                    }
                }
                else{
                    Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:1661-3406"));
                    startActivity(intent);
                }
            }
        });

        case7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7=new Intent(FirstActivity.this,HomePageActivity.class);
                startActivity(intent7);
            }
        });
        /*
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemPosition, long l) {
                switch(itemPosition){
                    case 0:
                        Intent intent0=new Intent(FirstActivity.this,LoginActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1=new Intent(FirstActivity.this,IntroduceActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(FirstActivity.this,MapActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(FirstActivity.this,JobActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(FirstActivity.this,QandAActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=new Intent(Intent.ACTION_VIEW);
                        try {
                            intent5.setData(Uri.parse("market://details?id=lee.example.lee.apt_check"));
                        }catch (android.content.ActivityNotFoundException anfe){
                            intent5.setData(Uri.parse("https://play.google.com/store/apps/details?id=lee.example.lee.apt_check"));
                        }
                        startActivity(intent5);
                        break;
                }
            }
        });*/
    }

}
