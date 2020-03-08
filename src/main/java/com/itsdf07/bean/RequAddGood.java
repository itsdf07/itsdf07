package com.itsdf07.bean;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/3/6
 */
public class RequAddGood {
    private String goodName;
    private String goodSku;
    private String mark;
    private int count;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodSku() {
        return goodSku;
    }

    public void setGoodSku(String goodSku) {
        this.goodSku = goodSku;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "goodName:" + goodName + ",goodSku:" + goodSku + ",count:" + count + ",mark:" + mark;
    }
}
