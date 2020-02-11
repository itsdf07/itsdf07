package com.itsdf07.bean;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/11
 */
public class RequAddHostsBean {

    /**
     * host : ggg
     * group : LOC
     */

    private String host;
    private String group;

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

    @Override
    public String toString() {
        return "group:" + group + ",host:" + host;
    }
}
