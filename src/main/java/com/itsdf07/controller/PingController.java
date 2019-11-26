package com.itsdf07.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itsdf07.bean.PingHostBean;
import com.itsdf07.bean.RespHostsBean;
import com.itsdf07.entity.PingHostEntity;
import com.itsdf07.service.PingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: App端Ping时收集对应IP接口控制器
 * @Auther: itsdf07
 * @Date: 2019/11/22 17:46
 **/
@RestController
@RequestMapping(value = "/ping")
@Api(tags = "Ping相关业务操作")
public class PingController {
    @Autowired
    private PingService pingService;

    @ApiOperation(
            value = "获取ping的目标主机API接口",
            httpMethod = "POST", protocols = "HTTP", produces = "application/json", response = String.class,
            notes = "Rquest：{\"group\":\"group\"}<br>" +
                    "Response：{\"code\":200,\"datas\":[{\"addresses\":[{\"prCreateDate\":1574666635000,\"prHost\":\"tts.baidu.com\",\"prIccid\":\"5288412\",\"prId\":1,\"prImei\":\"123456\",\"prIp\":\"115.239.211.61\",\"prNet\":\"4G\",\"prNextHost\":\"tts.n.shifen.com\",\"prOs\":\"8.0\",\"prProvider\":\"Android\"}],\"createTime\":1574411524000,\"group\":\"TTS\",\"host\":\"tts.baidu.com\"},{\"addresses\":[],\"createTime\":1574411524000,\"group\":\"TTS\",\"host\":\"tsn.baidu.com\"}],\"desc\":\"success\"}")
    @PostMapping(value = "/hosts")
    public String getPingHost(
            @ApiParam(name = "body", value = "Client端Json请求串", required = true)
            @RequestBody JSONObject group2Json) {
        String group = group2Json.get("group").toString();
        System.out.println("Ping目标主机下发接口:group=" + group);
        if ("".equals(group)) {
            group = null;
        }
        List<PingHostBean> hosts = pingService.getHostsByGroup(group);
        RespHostsBean respHostsBean = new RespHostsBean();

        if (hosts == null || hosts.isEmpty()) {
            respHostsBean.setDesc("failed");
            respHostsBean.setCode(404);
            respHostsBean.setDatas(hosts);
            return JSONObject.toJSONString(respHostsBean);
        }
        respHostsBean.setDesc("success");
        respHostsBean.setCode(200);
        respHostsBean.setDatas(hosts);
        return JSONObject.toJSONString(respHostsBean);
    }
}
