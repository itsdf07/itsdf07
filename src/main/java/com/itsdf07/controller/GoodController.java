package com.itsdf07.controller;

import com.alibaba.fastjson.JSONObject;
import com.itsdf07.bean.BaseRespBean;
import com.itsdf07.bean.RequAddGood;
import com.itsdf07.bean.RequHostBean;
import com.itsdf07.bean.RespGoodsBean;
import com.itsdf07.entity.GoodEntity;
import com.itsdf07.service.GoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/3/2
 */
@RestController
@RequestMapping(value = "/good")
@Api(tags = "")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @PostMapping(value = "/getGood")
    public String getGood(@RequestBody RequAddGood data2Bean) {
        System.out.println("getGood.................");
        List<GoodEntity> goodEntityList = goodService.findAllGoods();
        RespGoodsBean respGoodsBean = new RespGoodsBean();
        if (goodEntityList == null || goodService.findAllGoods().isEmpty()) {
            respGoodsBean.setCode(404);
            respGoodsBean.setDesc("无数据");
        } else {
            respGoodsBean.setCode(200);
            respGoodsBean.setDesc("请求成功");
            respGoodsBean.setDatas(goodEntityList);
        }
        return JSONObject.toJSONString(respGoodsBean);
    }

    @PostMapping(value = "/addGood")
    public String addGood(@RequestBody RequAddGood data2Bean) {
        System.out.println("addGood->" + data2Bean.toString());
        GoodEntity goodEntity = new GoodEntity();
        goodEntity.setGoodName(data2Bean.getGoodName());
        goodEntity.setGoodSku(data2Bean.getGoodSku());
        goodEntity.setGoodCount(0);
        goodEntity.setGoodMark(data2Bean.getMark());
        goodEntity.setGoodPicture("暂无图片");
        goodEntity.setGoodCreateDtime(new Date());
        int result = goodService.addGood(goodEntity);
        BaseRespBean baseRespBean = new BaseRespBean();
        baseRespBean.setCode(result > 0 ? 200 : 500);
        baseRespBean.setDesc(result > 0 ? "添加成功" : "添加失败");
        return JSONObject.toJSONString(baseRespBean);
    }

    @PostMapping(value = "/addUpdate")
    public String addUpdate(@RequestBody RequAddGood data2Bean) {
        System.out.println("addUpdate->" + data2Bean.toString());
        GoodEntity goodEntity = goodService.findGoodBySku(data2Bean.getGoodSku());
        BaseRespBean baseRespBean = new BaseRespBean();
        if (null == goodEntity) {
            baseRespBean.setCode(500);
            baseRespBean.setDesc("更新失败");
            return JSONObject.toJSONString(baseRespBean);
        } else {
            goodEntity.setGoodCount(goodEntity.getGoodCount() + data2Bean.getCount());
            int result = goodService.update(goodEntity);
            baseRespBean.setCode(result > 0 ? 200 : 500);
            baseRespBean.setDesc(result > 0 ? "更新成功" : "更新失败");
            return JSONObject.toJSONString(baseRespBean);
        }

    }
}
