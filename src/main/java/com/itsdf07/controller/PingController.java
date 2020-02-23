package com.itsdf07.controller;

import com.alibaba.fastjson.JSONObject;
import com.itsdf07.bean.*;
import com.itsdf07.entity.PingResultEntity;
import com.itsdf07.service.impl.PingService;
import com.itsdf07.utils.StringUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: App端Ping时收集对应IP接口控制器
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date: 2019/11/22
 **/
@RestController
@RequestMapping(value = "/ping")
@Api(tags = "主机IP收集业务操作")
public class PingController {
    @Autowired
    private PingService pingService;


    @ApiOperation(
            value = "新增目标主机",
            httpMethod = "POST",
            protocols = "HTTP",
            produces = "application/json",
            response = String.class,
            notes = "增加目标主机")
    @RequestMapping(value = "/addhost", method = RequestMethod.POST)
    public String addHost(
            @ApiParam(name = "body", value = "Json请求串", required = true)
            @RequestBody RequAddHostsBean dataBean) {
        System.out.println("新增的目标主机" + dataBean.toString());
        List<PingResultEntity> pingResultEntities = new ArrayList<>();
        //TODO 待优化：如果已经存在，则相同数据不重复插入
        int cnt = pingService.insertHost(dataBean.getHost(), dataBean.getGroup());
        System.out.println("插入数量:cnt=" + cnt);
        BaseRespBean baseRespBean = new BaseRespBean();
        if (cnt > 0) {
            baseRespBean.setCode(200);
            baseRespBean.setDesc("成功新增了" + dataBean.getHost() + "数据");
        } else {
            baseRespBean.setCode(400);
            baseRespBean.setDesc("新增" + dataBean.getHost() + "数据失败，可能已经存在");
        }

        return JSONObject.toJSONString(baseRespBean);
    }


    @ApiOperation(
            value = "获取分类目标主机",
            httpMethod = "POST",
            protocols = "HTTP",
            produces = "application/json",
            response = String.class,
            notes = "根据分类获得对应的目标主机域名/IP")
    @PostMapping(value = "/hosts")
    public String getPingHost(
            @ApiParam(name = "body", value = "Client端Json请求串", required = true)
            @RequestBody RequHostBean data2Bean) {
        String group = data2Bean.getGroup();
        System.out.println("目标主机分类:group=" + group);
        if (StringUtils.isEmpty(group)) {
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


    @ApiOperation(
            value = "新增目标主机IP地址",
            httpMethod = "POST",
            protocols = "HTTP",
            produces = "application/json",
            response = String.class,
            notes = "增加目标主机未出现过的IP地址")
    @PostMapping(value = "/hostsReuslt")
    public String addPingResult(
            @ApiParam(name = "body", value = "Json请求串", required = true)
            @RequestBody RequAddPingResultBean requAddPingResultBean) {
        System.out.println("需要新增的IP信息:datas=\n" + requAddPingResultBean.toString());
        List<PingResultEntity> pingResultEntities = new ArrayList<>();
        Date createTime = new Date();
        for (RequAddPingResultBean.DatasBean bean :
                requAddPingResultBean.getDatas()) {
            if (bean == null) {
                continue;
            }
            PingResultEntity pingResultEntity = new PingResultEntity();
            pingResultEntity.setPrIccid(bean.getIccid());
            pingResultEntity.setPrImei(bean.getImei());
            pingResultEntity.setPrOs(bean.getOs());
            pingResultEntity.setPrOsVersion(bean.getOsVersion());
            pingResultEntity.setPrProvider(bean.getProvider());
            pingResultEntity.setPrNetType(bean.getNetType());
            pingResultEntity.setPrHost(bean.getHost());
            pingResultEntity.setPrNextHost(bean.getNextHost());
            pingResultEntity.setPrIp(bean.getIp());
            pingResultEntity.setPrCreateDate(createTime);
            pingResultEntities.add(pingResultEntity);
        }
        //TODO 待优化：如果已经存在，则相同数据不重复插入
        int cnt = pingService.insertBatch2PingResults(pingResultEntities);
        System.out.println("插入数量:cnt=" + cnt);
        BaseRespBean baseRespBean = new BaseRespBean();
        baseRespBean.setCode(200);
        baseRespBean.setDesc("成功新增了" + cnt + "数据");
        return JSONObject.toJSONString(baseRespBean);
    }

}
