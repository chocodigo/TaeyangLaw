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

public class A02Activity extends AppCompatActivity{
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
        setContentView(R.layout.activity_a02);
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
        mTimeLineAdapter = new TimeLineAdapter(mDataList, mOrientation, mWithLinePadding, A02Activity.this);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    public void setDataListItems(){
        mDataList.add(new TimeLineModel("1. 입주자"+
                "\n협의회 선정 은행별 대출조건 비교","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("2. 입주자"+
                "\n협의회 선정 은행 대출신청"+
                "\n<구비서류 은행제출>","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("3. 은행 및 본인"+
                "\n잔금납부 및 중도금대출상환"+
                "\n<비대출-본인, 대출자-은행>","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("4. 은행"+
                "\n대출 실행 후 법무팀으로 서류이관","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("5. 태양법률사무소"+
                "\n각 세대별 유선연락"+
                "\n<선납할인 등 감면유무 확인>","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("6. 태양법률사무소"+
                "\n접수세대 검인신청","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("7. 태양법률사무소"+
                "\n취득세 신고대행 및 수령","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("8. 태양법률사무소"+
                "\n매도인(시행사) 결제요청"+
                "\n<등기필정보, 매도용인감, 위임장, 법인인감날인>","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("9. 태양법률사무소"+
                "\n각 세대별 소유권이전등기 비용안내","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("10. 태양법률사무소"+
                "\n소유권이전 등기비용 입금확인","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("11. 태양법률사무소"+
                "\n채권발행 및 공과금 납부","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("12. 태양법률사무소"+
                "\n서류취합 후 등기신청서 작성업무","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("13. 태양법률사무소"+
                "\n등기소 접수","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("14. 태양법률사무소"+
                "\n등기완료세대 송달주소 확인","", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("15. 태양법률사무소"+
                "\n등기권리증 교부 및 비용정산","", OrderStatus.COMPLETED));
    }
}
