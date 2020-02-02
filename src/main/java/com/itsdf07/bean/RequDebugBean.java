package com.itsdf07.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date: 2019/11/26
 **/
@ApiModel(value = "Debug前端数据请求基类")
public class RequDebugBean {
    @ApiModelProperty(name = "loginId", value = "登陆Id<br>测试请使用：itsdf07", notes = "登陆Id", dataType = "String", required = true, example = "itsdf07")
    @NotBlank(message = "登陆ID不能为空")
    private String loginId;
    @ApiModelProperty(name = "passwd", value = "登陆密码<br>测试请使用：123456", notes = "登陆密码", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "登陆密码能为空")
    private String passwd;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "loginId:" + loginId + ",passwd:" + passwd;
    }
}
