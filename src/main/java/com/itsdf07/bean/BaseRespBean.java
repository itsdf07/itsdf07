package com.itsdf07.bean;

/**
 * @Description:
 * @Auther: itsdf07
 * @Date: 2019/11/25 10:31
 **/
public class BaseRespBean {
    private String desc;
    private int code;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "code:" + code + ",desc:" + desc;
    }
}
