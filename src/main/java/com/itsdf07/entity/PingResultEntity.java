package com.itsdf07.entity;

import java.util.Date;

public class PingResultEntity {
    private Integer prId;

    private String prIccid;

    private String prImei;

    private Integer prOs;

    private String prOsVersion;

    private Integer prProvider;

    private Integer prNetType;

    private String prHost;

    private String prNextHost;

    private String prIp;

    private Date prCreateDate;

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getPrIccid() {
        return prIccid;
    }

    public void setPrIccid(String prIccid) {
        this.prIccid = prIccid;
    }

    public String getPrImei() {
        return prImei;
    }

    public void setPrImei(String prImei) {
        this.prImei = prImei;
    }

    public Integer getPrOs() {
        return prOs;
    }

    public void setPrOs(Integer prOs) {
        this.prOs = prOs;
    }

    public String getPrOsVersion() {
        return prOsVersion;
    }

    public void setPrOsVersion(String prOsVersion) {
        this.prOsVersion = prOsVersion;
    }

    public Integer getPrProvider() {
        return prProvider;
    }

    public void setPrProvider(Integer prProvider) {
        this.prProvider = prProvider;
    }

    public Integer getPrNetType() {
        return prNetType;
    }

    public void setPrNetType(Integer prNetType) {
        this.prNetType = prNetType;
    }

    public String getPrHost() {
        return prHost;
    }

    public void setPrHost(String prHost) {
        this.prHost = prHost;
    }

    public String getPrNextHost() {
        return prNextHost;
    }

    public void setPrNextHost(String prNextHost) {
        this.prNextHost = prNextHost;
    }

    public String getPrIp() {
        return prIp;
    }

    public void setPrIp(String prIp) {
        this.prIp = prIp;
    }

    public Date getPrCreateDate() {
        return prCreateDate;
    }

    public void setPrCreateDate(Date prCreateDate) {
        this.prCreateDate = prCreateDate;
    }
}