package com.itsdf07.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itsdf07.bean.BaseRespBean;
import com.itsdf07.bean.RequTestBean;
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
@RequestMapping(value = "/swagger")
@Api(tags = "Swagger2的文档例子Controller，同时也可用于API接口调试")
public class SwaggerController {

    /**
     * 接口测试
     *
     * @param data2Json
     * @return
     */
    @ApiOperation(
            value = "Json格式请求测试接口",
            httpMethod = "POST", protocols = "HTTP", produces = "application/json", response = String.class,
            notes = "仅限用于接口调通测试使用,Client端发起json请求，Service端json接收<br>" +
                    "Rquest：{\"username\":\"itsdf07\",\"passwd\":\"123456\"}<br>" +
                    "Response：{\"code\": 200,\"desc\": \"本次测试数据：username:itsdf07,passwd:123456\"}")
    @PostMapping(value = "/json2json")
    public String onTest(
            @ApiParam(name = "body", value = "Json请求串", required = true)
            @RequestBody JSONObject data2Json) {
        System.out.println("API测试接口:" + data2Json.toJSONString());
        RequTestBean requTestBean = JSON.parseObject(data2Json.toJSONString(), RequTestBean.class);
        BaseRespBean bean = new BaseRespBean();
        bean.setDesc("本次测试数据：" + requTestBean.toString());
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
            value = "Json格式请求测试接口",
            httpMethod = "POST", protocols = "HTTP", produces = "application/json", response = String.class,
            notes = "仅限用于接口调通测试使用,Client端发起json请求，Service端Bean类接收<br>" +
                    "Rquest：{\"username\":\"itsdf07\",\"passwd\":\"123456\"}<br>" +
                    "Response：{\"code\": 200,\"desc\": \"本次测试数据：username:itsdf07,passwd:123456\"}")
    @PostMapping(value = "/json2bean")
    public String onTest(
            @ApiParam(name = "body", value = "Json请求串", required = true)
            @RequestBody RequTestBean data2Bean) {
        System.out.println("API测试接口::" + data2Bean.toString());
        BaseRespBean bean = new BaseRespBean();
        bean.setDesc("本次测试数据：" + data2Bean.toString());
        bean.setCode(200);
        return JSONObject.toJSONString(bean);
    }
}
