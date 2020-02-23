package com.itsdf07.service.impl;

import com.itsdf07.entity.GoodsEntity;
import com.itsdf07.mapper.GoodsEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/17
 */
@Service
public class GoodService {
    @Autowired
    private GoodsEntityMapper goodsEntityMapper;

    /**
     * 添加商品
     *
     * @param dataBean
     * @return 0-添加失败，1-添加成功
     */
    public int addGood(GoodsEntity dataBean) {
        List<GoodsEntity> goods = goodsEntityMapper.selectGoods(dataBean);
        if (goods != null && !goods.isEmpty() && (goods.get(0).getGoodName().equals(goods.get(0).getGoodName())
                || dataBean.getGoodSku().equals(goods.get(0).getGoodSku()))) {
            return 0;
        }
        dataBean.setGoodCreateDtime(new Date());
        int status = goodsEntityMapper.insert(dataBean);
        return 1;
    }

    public List<GoodsEntity> getGoods() {
        List<GoodsEntity> goods = goodsEntityMapper.selectGoods(null);
        return goods;
    }
}
