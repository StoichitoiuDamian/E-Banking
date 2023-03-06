package controller;

import model.Money;

public class SchimbValutarBack {
    private String firstMon;
    private double val;
    private String secondMon;


    public SchimbValutarBack(String firstMon,float val,String secondMon) {
        this.firstMon=firstMon;
        this.val=val;
        this.secondMon=secondMon;
    }

    public String returnValue(){
        Money mon1=new Money(this.firstMon);
        Money mon2=new Money(this.secondMon);

        return String.valueOf(this.val*mon1.getValue()/mon2.getValue());
    }

}
