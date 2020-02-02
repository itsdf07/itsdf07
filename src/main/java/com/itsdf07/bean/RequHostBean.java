package com.itsdf07.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/2
 */
@ApiModel(value = "请求分类主机")
public class RequHostBean {
    //{"group":"TTS"}
    @ApiModelProperty(name = "group", value = "分组", notes = "目标主机分组", dataType = "String", required = true, example = "TTS")
    @NotBlank(message = "密码不能为空")
    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
