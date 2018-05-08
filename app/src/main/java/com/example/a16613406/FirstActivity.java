package com.example.a16613406;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2018-04-17.
 */

public class FirstActivity extends AppCompatActivity {
    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mContext = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        ArrayList items = new ArrayList<>();

        items.add(new Item("등기권리증 조회","소유권이전등기 진행과정을 조회합니다.",R.drawable.search));
        items.add(new Item("변호사 소개", "태양법률사무소 대표 변호사님을 소개해드립니다. ", R.drawable.lawyer));
        items.add(new Item("찾아오시는 길", "태양법률사무소의 주소입니다.", R.drawable.map));
        items.add(new Item("업무 분야", "태양법률사무소의 업무를 소개합니다.", R.drawable.job));
        items.add(new Item("Q and A","자주 묻는 질문들입니다.",R.drawable.question));
        items.add(new Item("공용부점검", "아파트 공용부점검 어플리케이션 설치로 바로가기", R.drawable.setting));

        layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        Adapter=new MyAdapter(items,mContext);
        recyclerView.setAdapter(Adapter);


        Toolbar myToolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.mark);




    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private Context context;
        private List<Item> mItems;
        private RecyclerView recyclerView;

        private int lastPostiion=-1;

        public MyAdapter(ArrayList items, Context mContext){
            mItems=items;
            context=mContext;
            recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,parent,false);
            ViewHolder holder=new ViewHolder(v);


            return holder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final int _position=position;
            holder.imageView.setImageResource(mItems.get(position).getImg());
            holder.textView1.setText(mItems.get(position).getTitle());
            holder.textView2.setText(mItems.get(position).getSubTitle());

            setAnimation(holder.imageView,position);

        }

        @Override
        public int getItemCount(){
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            CardView cardView;
            public ImageView imageView;
            public TextView textView1;
            public TextView textView2;

            public ViewHolder(View view){
                super(view);
                imageView=(ImageView)view.findViewById(R.id.card);
                textView1=(TextView)view.findViewById(R.id.Title);
                textView2=(TextView)view.findViewById(R.id.SubTitle);
                view.setOnClickListener(this);
            }

            @Override
            public void onClick(View v){
                int itemPosition=recyclerView.getChildLayoutPosition(v);
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
        }

        private void setAnimation(View viewToAnimate,int position){
            if(position>lastPostiion){
                Animation animation= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPostiion=position;
            }
        }
    }

}
