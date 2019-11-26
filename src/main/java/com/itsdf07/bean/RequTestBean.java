package com.itsdf07.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Auther: itsdf07
 * @Date: 2019/11/26 11:31
 **/
@ApiModel
public class RequTestBean {
    @ApiModelProperty(name = "username", value = "itsdf07", notes = "本次处理信息", dataType = "String", required = true)
    private String username;
    @ApiModelProperty(name = "passwd", value = "123456", notes = "本次处理信息", dataType = "String", required = true)
    private String passwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "username:" + username + ",passwd:" + passwd;
    }
}
