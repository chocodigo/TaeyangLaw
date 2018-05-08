package com.example.a16613406;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Display;
import android.widget.ExpandableListView;

import java.util.ArrayList;

/**
 * Created by lee on 2018-04-23.
 */

public class QandAActivity extends ApplyActivity {
    private ExpandableListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);
        Display newDisplay=getWindowManager().getDefaultDisplay();
        int width=newDisplay.getWidth();

        ArrayList<myGroup> DataList=new ArrayList<myGroup>();
        listView=(ExpandableListView)findViewById(R.id.qalist);
        myGroup qa=new myGroup("등기신청 접수 및 방법");
        qa.child.add("대출신청 예정세대 - 별도접수 없음: 대출실행 후 제출 서류 자동이관되어 one-stop service 등기처리됨");
        qa.child.add("대출없이 중도금 및 잔금완납 세대-현장접수 및 우편접수");
        DataList.add(qa);

        qa=new myGroup("소유권이전등기 및 대출 진행과정");
        qa.child.add("1. (입주자) 협의회 선정 은행별 대출조건 비교");
        qa.child.add("2. (입주자) 협의회 선정 은행 대출신청<구비서류 은행제출>");
        qa.child.add("3. (은행 및 본인)잔금납부 및 중도금대출상환 <비대출-본인, 대출자- 은행>");
        qa.child.add("4. (은행) 대출 실행 후 법무팀으로 서류이관");
        qa.child.add("5. (태양법률사무소) 각 세대별 유선연락<선납할인 등 감면유무 확인>");
        qa.child.add("6. (태양법률사무소) 접수세대 검인신청");
        qa.child.add("7. (태양법률사무소) 취득세 신고대행 및 수령");
        qa.child.add("8. (태양법률사무소) 매도인(시행사)결제요청 <등기필정보, 매도용인감, 위임장, 법인인감날인>");
        qa.child.add("9. (태양법률사무소) 각 세대별 소유권이전등기 비용안내");
        qa.child.add("10. (태양법률사무소) 소유권이전 등기비용 입금확인");
        qa.child.add("11. (태양법률사무소) 채권발행 및 공과금 납부");
        qa.child.add("12. (태양법률사무소) 서류취합 후 등기신청서 작성업무");
        qa.child.add("13. (태양법률사무소) 등기소 접수");
        qa.child.add("14. (태양법률사무소) 등기완료세대 송달주소 확인");
        qa.child.add("15. (태양법률사무소) 등기권리증 교부 및 비용정산");
        DataList.add(qa);

        qa=new myGroup("소유권이전등기 필요서류");
        qa.child.add("* 비대출 세대");
        qa.child.add("1. 분양계약서 원본");
        qa.child.add("2. 옵션(발코니)계약서 원본");
        qa.child.add("3. 주민등록초본 1통(최근 5년 주소 포함)");
        qa.child.add("* 대출 신청세대(협의회 선정은행에 접수)");
        qa.child.add("1. 분양계약서 원본");
        qa.child.add("2. 옵션(발코니)계약서 원본");
        qa.child.add("3. 주민등록등본 2통");
        qa.child.add("4. 인감증명서 2통");
        qa.child.add("5. 주민등록초본 1통(최근 5년 주소포함)");
        qa.child.add("6. 인감도장");
        qa.child.add("7. 신분증");
        qa.child.add("8. 소득증빙자료");
        qa.child.add("* (추가서류) 전매세대 : 매매계약서 원본, 부동산거래신고필증(전매횟수 모든 서류)");
        qa.child.add("* (추가서류) 증여세대 : 증여계약서 원본");
        DataList.add(qa);

        qa=new myGroup("분양권 명의변경 절차");
        qa.child.add("1. 분양 사무소에 사전 전화문의/예약(최소 1일전)");
        qa.child.add("2. 매매계약서 작성(증여계약서 작성)");
        qa.child.add("3. 검인[부동산실거래신고](세종시청)");
        qa.child.add("4. 대출유무");
        qa.child.add("4-1.(대출 있을 경우) 대출 승계(중도금 대출은행)- 매수/매도자 동행");
        qa.child.add("5. 분양사무소 방문 - 매수/매도자 동행");
        qa.child.add("6. 명의변경 진행");
        qa.child.add("7. 사업주체 승인완료");
        DataList.add(qa);

        qa=new myGroup("부부 공동명의 신청 방법");
        qa.child.add("* 방문 순서");
        qa.child.add("1) 세종시청(증여계약서 작성. 1층 민원실)");
        qa.child.add("2) 중도금 받은 은행(중도금대출 채무승계)");
        qa.child.add("* 시청 준비 서류");
        qa.child.add("두 분 중 한 분만 갈 경우 각각의 신분증과 인감도장을 지참하고 방문 - 증여계약서(시청에 비치),신분증, 인감도장");
        qa.child.add("* 중도금은행 제출 서류(중도금 은행은 부부가 같이 은행에 방문해야 함 - 자필 서명) ");
        qa.child.add("1) 분양계약서 원본");
        qa.child.add("2) 증여계약서 사본");
        qa.child.add("3) 주민등록초본 1통(증여받는 분)");
        qa.child.add("4) 주민등록등본 1통(부부주소가 다를 경우 가족관계증명서 추가)");
        qa.child.add("5) 인감증명서 1통(증여받는 분)");
        qa.child.add("6) 인감도장 및 신분증(부부 각각)");
        qa.child.add("* 건설사 (시행사) 제출서류");
        qa.child.add("1) 전매동의 신청서(계약자 인감날인, 건설사 비치)");
        qa.child.add("2) 분양계약서 원본, 옵션계약서 원본");
        qa.child.add("3) 검인증여 계약서(세종시청 민원실에서 작성 검인한 것)");
        qa.child.add("4) 인감증명서 한 통씩(인감증명서는 꼭 본인이 발급받을 것)");
        qa.child.add(" - 원계약자 : 부동산 매도용 부동산 매수란에 배우자(증여받는 분)의 인적사항 기재");
        qa.child.add(" - 배우자(증여받는 분) : 일반용도");
        qa.child.add("5) 인감도장, 신분증 지참");
        qa.child.add("6) 주민등록등본(주소가 다를 경우 각각)");
        qa.child.add("7) 중도금 승계동의서(중도금이 있을 경우)");
        qa.child.add("* 분양권 승계완료(증여=공동명의 완료)");
        qa.child.add("계약자 1인 -> 부부 명의 공동 등재 -> 완료 후 공동명의 계약서(권리의무 승계계약서) 중도금은행에 팩스 발송");
        DataList.add(qa);

        qa=new myGroup("대출 및 등기서류 접수");
        qa.child.add("* 대출세대 : <중도금대출을 상환하지 않고, 잔금대출(담보대출)로 전환하는 세대>");
        qa.child.add("대출받으실 은행으로부터 '원하는 입주일로부터 최소 2주전'에는 필요서류제출과 함께 대출신청을 해주셔야 하십니다. 은행대출이 있으신 경우, 소유권이전 등기와 함께 근저당권설정 등기가 같이 진행됩니다.");
        qa.child.add("* 미대출세대 : <중도금대출을 전부 상환하여, 대출신청없이 소유권이전등기만 진행하는 세대>");
        qa.child.add("입주 후 입주자 카페 및 아파트에 일정을 공지할 예정입니다.");
        DataList.add(qa);

        qa=new myGroup("잔금조회 및 납부(대출신청세대는 신청한 은행에서 일괄안내)");
        qa.child.add("입금하실 분양대금, 옵션대금 조회(입금일자 기준 - 연체료 포함)");
        qa.child.add("* 납부기간 : 입주 전(최소 당일까지) 납부(무통장 입금증(영수증) 필히 지참)");
        qa.child.add("* 선납할인 : 입주 개시전일 기준으로 할인금액이 적용됨.");
        qa.child.add("* 연체료 : 입주만료 익일부터는 입주여부에 상관없이 미납금액에 대해 연체료가 부과됨(입주 지정기간동안에는 잔금에 대해 할인료 및 연체료가 발생하지 않음)");
        DataList.add(qa);

        qa=new myGroup("인수증 발급");
        qa.child.add("* 발급기간 : 입주 지정기간 지정일부터 '입주지원센터'에서 발급");
        qa.child.add("* 구비서류 : 분양대금, 옵션대금 납부영수증, 계약자 신분증, 대리인 수령일 경우 가족확인서류 등");
        qa.child.add("* 추가서류 : 주민등록등본이나 의료보험증 또는 호적등본 1통, 대리인 신분증");
        qa.child.add("* 장소 : 입주지원센터 (통상 입주개시 1주일전 오픈)");
        DataList.add(qa);

        qa=new myGroup("열쇠(key)인수");
        qa.child.add("입주증 발급, 차량테크 출입증 및 선수관리비 납부 확인 후, 열쇠 인수 가능");
        qa.child.add("* 구비서류 : 입주증(선수관리비 납부 확인 필), 도장, 신분증");
        qa.child.add("* 장소 : 입주사무실");
        DataList.add(qa);

        qa=new myGroup("등록 및 신고 사항");
        qa.child.add("* 주민등록 전입신고");
        qa.child.add(" 입주일로부터 15일 이내에 전자민원(G4C) 또는 관할지 주민센터에 신고한다.");
        qa.child.add(" - 구비서류 : 전입신고서(동, 사무소), 자동차 등록증, 주민등록증(전가족), 세대주 인감도장, 운전면허증");
        qa.child.add("* 국민건강보험 : 전입신고시 자동등록");
        qa.child.add("* 차량이전등록 : 전입신고시 자동등록");
        qa.child.add("* 학교 전/입학");
        qa.child.add(" - 초등학교 : 주민등록 전입신고로 절차 완료(전입신고시 주민센터에 문의)");
        qa.child.add(" - 중학교 : 주민센터 전입신고 후 교육청에 방문하여 배정원서 작성 후 배정");
        qa.child.add(" - 고등학교 : 해당 지역의 교육청에 문의");
        DataList.add(qa);

        qa=new myGroup("취득세납부는 언제 해야 하나요?");
        qa.child.add("취득세는 '사용승인일'과 '잔금완납일' 중 늦은 날로부터 60일 이내에 신고 및 납부하셔야 합니다. (기한 초과시 납부할 취득세의 10%, 일자별가산 과태)");
        DataList.add(qa);

        qa=new myGroup("취득세고지서 발급과 납부 방법은?");
        qa.child.add("협약된 은행 및 당사에 접수하신 세대는 신고대행을 하며, 납부방법은 추후에 공지하겠습니다.");
        DataList.add(qa);

        qa=new myGroup("소유권이전등기 접수 기한은?");
        qa.child.add("소유권이전등기는 '소유권보존등기일'과 '잔금 완납일' 중 늦은 날로부터 60일 이내에 등기소에 접수하여야 합니다. (기한 초과시 공급가액의 0.1%)");
        DataList.add(qa);

        qa=new myGroup("보존등기란?");
        qa.child.add("부동산 소유권의 보존을 위하여 미등기 부동산에 대하여 처음 등기하는 것(최초등기)을 말합니다. [추가로/ 보존등기가 시행사 앞으로 완료되어야 수분양자 앞으로 소유권이전등기를 할 수 있습니다.(취득세 신고 및 납부기한과 등기기한은 차이가 있습니다.)");
        DataList.add(qa);

        qa=new myGroup("소유권이전등기 절차/소요기간/필요서류는?");
        qa.child.add("아래일정은 대출신청세대 진행사항이며, 단체등기의 특성상 등기소 경료시간지체 등의 사유로 통상적으로 당사 서류 이관 또는 등기서류 접수이후 완료까지 최소 60일~90일 정도가 소요될 수 있습니다.");
        DataList.add(qa);

        qa=new myGroup("공동으로의 명의변경(권리의무승계)은 언제? 장점은?");
        qa.child.add("공동명의로 변경하고자 하는 경우, 반드시 '잔금완납 이전'에 권리의무승계 절차(공동으로의 명의 변경)를 진행하셔야 합니다. 매년 재산세 납부시 기준시가 2억기준으로 약 2만원정도 절감효과가 있다 하겠으며, 추후 2주택이상자가 매도할 대 양도차액이 발생하여 양도세 부과대상일 경우 양도세 절감효과가 있을 수 있습니다.");
        DataList.add(qa);

        qa=new myGroup("사용승인(준공)");
        qa.child.add("'사용승인(준공)'을 득하면 입주가 가능해집니다.");
        qa.child.add("사전점검행사 이후 시행사는 예상되는 사용승인일 전에 입주지정기간을 확정하여 수분양자에게 통지하며, 수분양자는 이때 입주날짜를 정하시면 됩니다.");
        qa.child.add("[참고] 수분양자는 입주시 1) 분양잔금 완납과 2) 중도금 대출금 상환(현금상환 도는 잔금대출로 전환) 및 3)선수관리비 예치 등이 확인되어야 입주증을 받으실 수 있습니다.");
        DataList.add(qa);

        qa=new myGroup("소유권보존등기");
        qa.child.add("'보존등기'란 최초로 토지 및 건물에 대한 권리관계를 등기부에 등재하는 것입니다.");
        qa.child.add("시행사는 사용승인(준공) 날로부터 60일 이내에 보존등기접수를 해야 합니다.");
        qa.child.add("보존등기가 완료되어야 각 세대별로 소유권이전등기를 진행할 수 있습니다.");
        DataList.add(qa);

        ExpandAdapter adapter=new ExpandAdapter(getApplicationContext(),R.layout.group_row,R.layout.child_row,DataList);
        listView.setAdapter(adapter);
    }
}
