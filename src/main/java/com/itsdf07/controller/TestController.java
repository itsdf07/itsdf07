package com.itsdf07.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 测试调试使用的接口控制器
 * @Auther: itsdf07
 * @Date: 2019/11/22 16:51
 **/
@RestController
@RequestMapping(value = "/manager")
@Api(description = "测试调试使用的接口控制器")
public class TestController {

    /**
     * 接口测试
     *
     * @param data2Json
     * @return
     */
    @ApiOperation(value = "测试接口", httpMethod = "POST", notes = "接口发布说明")
    @PostMapping(value = "/test")
    public String onTest(
            @ApiParam(name = "body", value = "{\"username\":\"itsdf07\",\"passwd\":\"123456\"}", required = true)
            @RequestBody JSONObject data2Json) {
        System.out.println("测试接口->test:" + data2Json.toJSONString());
        return data2Json.toJSONString();
    }
}
