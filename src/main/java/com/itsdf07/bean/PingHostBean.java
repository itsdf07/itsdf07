package com.itsdf07.bean;

import java.util.Date;
import java.util.List;

/**
 * @Description: 目标主机
 * @Auther: itsdf07
 * @Date: 2019/11/25 14:14
 **/
public class PingHostBean {
    private String host;
    private String group;
    private Date createTime;
    private List<PingAddressBean> addresses;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<PingAddressBean> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PingAddressBean> addresses) {
        this.addresses = addresses;
    }
}
