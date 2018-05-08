package com.example.a16613406;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2018-04-19.
 */

public class JobActivity extends AppCompatActivity {

    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        recyclerView = (RecyclerView) findViewById(R.id.job_recycle);
        recyclerView.setHasFixedSize(true);

        ArrayList items = new ArrayList<>();

        items.add(new jobItem("형사","태양법률사무소",R.drawable.hammer,"고객들의 형사소송에 관하여 피고인에 대한 유․무죄를 가리고 경찰․검찰의 내사 수사초기단계에서부터 법원의 공판절차에 이르기까지는 물론이고 고소 및 불기소처분에 대한 항고,재심 및 형사보상청구 등 고객들의 권리와 보호를 받을 수 있도록 체계적인 변호활동을 하여 최고의 결과를 도출해내기 위해 대리하고 있습니다."));
        items.add(new jobItem("민사", "태양법률사무소", R.drawable.people,"고객들의 경제상황에서 일어나는 권리 또는 법률관계에 대한 분쟁사건들에 대해 재판권에 의한 가처분이나 본안 소송을 활용하여 법률적, 강제적으로 해결하는 절차입니다. 소송경험을 통해 소송수행능력을 갖추어 만족스러운 최상의 법률서비스를 제공하여 궁극적이 해결책을 찾아 전문적으로 처리하고 있습니다."));
        items.add(new jobItem("행정", "태양법률사무소", R.drawable.adm,"행정기관의 영향력이 확대되어가고 있는 시기에 부당한 행정처분 등으로 권리를 침해를 당한 고객으로부터 행정심판 및 행정소송과 관련하여 전 절차에서 권리구제 방안의 자문을 제공하고, 원만한 소송을 수행을 하여 최상의 법률서비스를 제공하고 있습니다."));
        items.add(new jobItem("기업", "태양법률사무소", R.drawable.company,"기업 경영에서 일반적으로 발생하는 모든 법률문제에 관하여 자문 제공은 물론 회사 설립 경영, 기업의 인수․합병 등 기업환경 속에서 고객의 요구사항에 맞는 체계적인 지식과 경험업무를 통해 최선의 법률 서비스를 제공하고 있습니다."));
        items.add(new jobItem("건설","태양법률사무소",R.drawable.build,"건설분야는 대규모의 다양하고 복잡한 영역으로 건설의 각종 인허가 업무 및 공사 관련 계약 체결, 재개발․재건축등 행정규제 및 외에 행정처분과 관련한 법적 절차 및 자문등 각종 소송업무에 있어 최상의 지식을 지원해 드리고 있습니다."));
        items.add(new jobItem("등기", "태양법률사무소", R.drawable.reg,"등기란 특정한 소유권의 권리관계를 국가기관에 공시하기 위해 공적장부(등기부)에 법정 절차에 따라 기재하는 것을 말하며, 현행법상 법률행위의 안전한 거래를 도모하기 위하여 거래관계 및 거래목적물의 권리내용을 파악하여 위험요소의 블측한 손해를 입지 않도록 경험을 토대로 해결방안제시 및 대안을 찾아 체계적이고 신속하게 등기신청 절차를 대행해드리고 있습니다."));
        items.add(new jobItem("부동산","태양법률사무소",R.drawable.home,"부동산에 대한 가치가 증식함에 따라 권리 및 투자, 개발로 인한 법률관계가 활성화 되고 있으며, 이에 높은 수익을 가져오는 반면 위험성이 높은 분야이기에 소송 및 압류, 경매 절차 등 이외 다양한 부동산관련 소송을 실무 전문가들과 유기적으로 결합하여 질 높은 서비스를 제공하고 있습니다."));


        layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        Adapter=new MyAdapter(items,mContext);
        recyclerView.setAdapter(Adapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private Context context;
        private List<jobItem> mItems;
        private RecyclerView recyclerView;

        private int lastPostiion=-1;

        public MyAdapter(ArrayList items, Context mContext){
            mItems=items;
            context=mContext;
            recyclerView=(RecyclerView)findViewById(R.id.job_recycle);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item,parent,false);
            ViewHolder holder=new ViewHolder(v);

            return holder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final int _position=position;
            holder.imageView.setImageResource(mItems.get(position).getImg());
            holder.textView1.setText(mItems.get(position).getTitle());
            holder.textView2.setText(mItems.get(position).getSubTitle());
            holder.textView3.setText(mItems.get(position).getExplain());


        }

        @Override
        public int getItemCount(){
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            CardView cardView;
            public ImageView imageView;
            public TextView textView1;
            public TextView textView2;
            public TextView textView3;

            public ViewHolder(View view){
                super(view);
                imageView=(ImageView)view.findViewById(R.id.card);
                textView1=(TextView)view.findViewById(R.id.Title);
                textView2=(TextView)view.findViewById(R.id.SubTitle);
                textView3=(TextView)view.findViewById(R.id.explain);
            }
        }

    }
}
