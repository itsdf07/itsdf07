package com.itsdf07.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itsdf07.bean.BaseRespBean;
import com.itsdf07.bean.RequDebugBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 测试调试使用的接口控制器
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date: 2019/11/22
 **/
@RestController
@RequestMapping(value = "/debug")
@Api(tags = "参考教程：Swagger2的文档例子Controller，同时也可用于API接口调试")
public class SwaggerAndDebugController {

    /**
     * 接口测试
     *
     * @param data2Json
     * @return
     */
    @ApiOperation(
            value = "Json格式请求调试接口",
            httpMethod = "POST",
            protocols = "HTTP",
            produces = "application/json",
            response = String.class,
            notes = "仅调式Client与Service是否能正常交互，直接JSONObject类进行接收<br>" +
                    "{\"loginId\":\"itsdf07\",\"passwd\":\"123456\"}")
    @PostMapping(value = "/json2json")
    public String onDebugJson2Json(
            @ApiParam(name = "body", value = "Json请求串", required = true)
            @RequestBody JSONObject data2Json) {
        System.out.println("debug-json2json测试接口:" + data2Json.toJSONString());
        RequDebugBean requTestBean = JSON.parseObject(data2Json.toJSONString(), RequDebugBean.class);
        BaseRespBean bean = new BaseRespBean();
        bean.setDesc("本次调式数据内容：" + requTestBean.toString());
        bean.setCode(200);
        return JSONObject.toJSONString(bean);
    }

    /**
     * 接口测试
     *
     * @param data2Bean
     * @return
     */
    @ApiOperation(
            value = "Json格式请求调试接口",
            httpMethod = "POST",
            protocols = "HTTP",
            produces = "application/json",
            response = String.class,
            notes = "仅调式Client与Service是否能正常交互，直接Bean类进行接收")
    @PostMapping(value = "/json2bean")
    public String onDebugJson2Bean(
            @ApiParam(name = "body", value = "Json请求串", required = true)
            @RequestBody RequDebugBean data2Bean) {
        System.out.println("debug-json2bean测试接口:" + data2Bean.toString());
        BaseRespBean bean = new BaseRespBean();
        bean.setDesc("本次调式数据内容：" + data2Bean.toString());
        bean.setCode(200);
        return JSONObject.toJSONString(bean);
    }
}
