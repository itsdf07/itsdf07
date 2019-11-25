package com.itsdf07.entity;

import java.util.Date;

public class PingHostEntity {
    private Integer phId;

    private String phHost;

    private String phGroup;

    private Date phCreateDate;

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public String getPhHost() {
        return phHost;
    }

    public void setPhHost(String phHost) {
        this.phHost = phHost == null ? null : phHost.trim();
    }

    public String getPhGroup() {
        return phGroup;
    }

    public void setPhGroup(String phGroup) {
        this.phGroup = phGroup == null ? null : phGroup.trim();
    }

    public Date getPhCreateDate() {
        return phCreateDate;
    }

    public void setPhCreateDate(Date phCreateDate) {
        this.phCreateDate = phCreateDate;
    }
}