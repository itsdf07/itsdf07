package com.itsdf07.entity;

import java.util.Date;

public class PingResultEntity {
    private Integer prId;

    private String prIccid;

    private String prImei;

    private String prProvider;

    private String prOs;

    private String prNet;

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
        this.prIccid = prIccid == null ? null : prIccid.trim();
    }

    public String getPrImei() {
        return prImei;
    }

    public void setPrImei(String prImei) {
        this.prImei = prImei == null ? null : prImei.trim();
    }

    public String getPrProvider() {
        return prProvider;
    }

    public void setPrProvider(String prProvider) {
        this.prProvider = prProvider == null ? null : prProvider.trim();
    }

    public String getPrOs() {
        return prOs;
    }

    public void setPrOs(String prOs) {
        this.prOs = prOs == null ? null : prOs.trim();
    }

    public String getPrNet() {
        return prNet;
    }

    public void setPrNet(String prNet) {
        this.prNet = prNet == null ? null : prNet.trim();
    }

    public String getPrHost() {
        return prHost;
    }

    public void setPrHost(String prHost) {
        this.prHost = prHost == null ? null : prHost.trim();
    }

    public String getPrNextHost() {
        return prNextHost;
    }

    public void setPrNextHost(String prNextHost) {
        this.prNextHost = prNextHost == null ? null : prNextHost.trim();
    }

    public String getPrIp() {
        return prIp;
    }

    public void setPrIp(String prIp) {
        this.prIp = prIp == null ? null : prIp.trim();
    }

    public Date getPrCreateDate() {
        return prCreateDate;
    }

    public void setPrCreateDate(Date prCreateDate) {
        this.prCreateDate = prCreateDate;
    }
}