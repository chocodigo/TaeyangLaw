package com.taeyang.a16613406.question;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.taeyang.a16613406.R;
import com.taeyang.a16613406.TimeLineAdapter;
import com.taeyang.a16613406.model.OrderStatus;
import com.taeyang.a16613406.model.Orientation;
import com.taeyang.a16613406.model.TimeLineModel;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2018-05-21.
 */

public class A04Activity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();
    private Orientation mOrientation;
    private boolean mWithLinePadding;

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a04);
        mOrientation = Orientation.VERTICAL;
        mWithLinePadding = true;

        setTitle(mOrientation == Orientation.HORIZONTAL ? getResources().getString(R.string.horizontal_timeline) : getResources().getString(R.string.vertical_timeline));

        mRecyclerView = (RecyclerView) findViewById(R.id.timelineRecyclerView);
        mRecyclerView.setLayoutManager(getLinearLayoutManager());
        mRecyclerView.setHasFixedSize(true);

        initView();
    }
    private LinearLayoutManager getLinearLayoutManager() {
        if (mOrientation == Orientation.HORIZONTAL) {
            return new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        } else {
            return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        }
    }

    private void initView() {
        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(mDataList, mOrientation, mWithLinePadding, A04Activity.this);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    public void setDataListItems(){
        mDataList.add(new TimeLineModel("분양사무소에 사전 전화문의/예약 (최소 1일 전)","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("매매계약서 작성(증여계약서 작성)","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("검인[부동산실거래신고] (세종시청)","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("대출(O)\n대출 승계(중도금 대출은행)"+
                "\n- 매수/매도자 동행","", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("대출(X)\n분양사무소 방문\n- 매수/매도자 동행","", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("명의변경 진행","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("사업주체 승인완료","", OrderStatus.COMPLETED));

    }
}
