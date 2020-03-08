package com.itsdf07.entity;

import java.util.Date;

public class GoodEntity {
    private Integer goodId;

    private String goodName;

    private String goodSku;

    private String goodPicture;

    private Integer goodCount;

    private String goodMark;

    private Date goodCreateDtime;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodSku() {
        return goodSku;
    }

    public void setGoodSku(String goodSku) {
        this.goodSku = goodSku == null ? null : goodSku.trim();
    }

    public String getGoodPicture() {
        return goodPicture;
    }

    public void setGoodPicture(String goodPicture) {
        this.goodPicture = goodPicture == null ? null : goodPicture.trim();
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public String getGoodMark() {
        return goodMark;
    }

    public void setGoodMark(String goodMark) {
        this.goodMark = goodMark == null ? null : goodMark.trim();
    }

    public Date getGoodCreateDtime() {
        return goodCreateDtime;
    }

    public void setGoodCreateDtime(Date goodCreateDtime) {
        this.goodCreateDtime = goodCreateDtime;
    }
}