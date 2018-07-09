package com.taeyang.a16613406;

/**
 * Created by lee on 2018-04-26.
 */

public class customer {
    private String year_num;
    private String num;
    private String apt;
    private String pk1;
    private String pk2;
    private String name;
    private String name2;
    private String phone;

    //서류이관일
    private String office_date;
    //검인신청
    private String is_seal;
    //취득신고(신고유무)
    private String is_acquire;
    //취득세(납부일자)
    private String acquire_date;
    //총 등기비용
    private String reg_money;
    //등기 비용(입금일자)
    private String money_send_date;
    //실입금액
    private String deposit_money;
    //매도서류 수령
    private String is_get_sell;
    //등기소 접수일자
    private String reg_date;
    //등기 완료 일자
    private String reg_complete_date;
    //등기권리증 발송일자
    private String reg_send_date;
    //입금은행
    private String bank;
    //계좌번호
    private String account;
    //계좌명
    private String account_name;
    //비용입금O,X
    private String is_deposit;
    //대출은행
    private String loan_bank;
    //환급금
    private String refund_money;
    //환급일자
    private String refund_date;
    //문자보냈는지
    private String is_text;


    public String getYear_num(){
        return year_num;
    }
    public void setYear_num(String _year_num){
        this.year_num=_year_num;
    }

    public String getNum(){
        return num;
    }
    public void setNum(String _num){
        this.num=_num;
    }

    public String getApt(){
        return apt;
    }
    public void setApt(String _apt){
        this.apt=_apt;
    }

    public String getPk1(){
        return pk1;
    }
    public void setPk1(String _pk1){
        this.pk1=_pk1;
    }

    public String getPk2(){
        return pk2;
    }
    public void setPk2(String _pk2){
        this.pk2=_pk2;
    }

    public String get_Name(){
        return name;
    }
    public void set_Name(String _name){
        this.name=_name;
    }

    public String getName2(){
        return name2;
    }
    public void setName2(String _name2){
        this.name2=_name2;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String _phone){
        this.phone=_phone;
    }

    public String getOffice_date(){
        return office_date;
    }
    public void setOffice_date(String _office_date){
        this.office_date=_office_date;
    }

    public String getIs_seal(){
        return is_seal;
    }
    public void setIs_seal(String _is_seal){
        this.is_seal=_is_seal;
    }

    public String getIs_acquire(){
        return is_acquire;
    }
    public void setIs_acquire(String _is_acquire){
        this.is_acquire=_is_acquire;
    }

    public String getAcquire_date(){
        return acquire_date;
    }
    public void setAcquire_date(String _acquire_date){
        this.acquire_date=_acquire_date;
    }

    public String getReg_money(){
        return reg_money;
    }
    public void setReg_money(String _reg_money){
        this.reg_money=_reg_money;
    }

    public String getMoney_send_date(){
        return money_send_date;
    }
    public void setMoney_send_date(String _money_send_date){
        this.money_send_date=_money_send_date;
    }

    public String getIs_get_sell(){return is_get_sell;}
    public void setIs_get_sell(String is_get_sell){
        this.is_get_sell=is_get_sell;
    }

    public String getDeposit_money(){
        return deposit_money;
    }
    public void setDeposit_money(String _deposit_money){
        this.deposit_money=_deposit_money;
    }

    public String getReg_date(){
        return reg_date;
    }
    public void setReg_date(String _reg_date){
        this.reg_date=_reg_date;
    }

    public String getReg_complete_date(){
        return reg_complete_date;
    }
    public void setReg_complete_date(String _reg_complete_date){
        this.reg_complete_date=_reg_complete_date;
    }

    public String getReg_send_date(){
        return reg_send_date;
    }
    public void setReg_send_date(String _reg_send_date){
        this.reg_send_date=_reg_send_date;
    }

    public String getBank(){
        return bank;
    }
    public void setBank(String _bank){
        this.bank=_bank;
    }

    public String getAccount(){
        return account;
    }
    public void setAccount(String _account){
        this.account=_account;
    }

    public String getAccount_name(){
        return account_name;
    }
    public void setAccount_name(String _account_name){
        this.account_name=_account_name;
    }

    public String getIs_deposit(){
        return is_deposit;
    }
    public void setIs_deposit(String _is_deposit){
        this.is_deposit=_is_deposit;
    }

    public String getLoan_bank(){
        return loan_bank;
    }
    public void setLoan_bank(String _loan_bank){
        this.loan_bank=_loan_bank;
    }

    public String getRefund_money(){
        return refund_money;
    }
    public void setRefund_money(String _refund_money){
        this.refund_money=_refund_money;
    }

    public String getRefund_date(){
        return refund_date;
    }
    public void setRefund_date(String _refund_date){
        this.refund_date=_refund_date;
    }

    public String getIs_text(){return is_text;}
    public void setIs_text(String _is_text){this.is_text=_is_text;}
}
