package com.itsdf07.service.impl;

//import com.itsdf07.entity.GoodsEntity;
//import com.itsdf07.mapper.GoodsEntityMapper;

import com.itsdf07.entity.GoodEntity;
import com.itsdf07.mapper.GoodEntityMapper;
import com.itsdf07.service.GoodService;
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
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodEntityMapper goodEntityMapper;

    @Override
    public GoodEntity findGoodByName(String goodName) {
        return findGoodByNameAndSku(goodName, null);
    }

    @Override
    public GoodEntity findGoodBySku(String goodSku) {
        List<GoodEntity> goodEntityList = goodEntityMapper.selectGoodBySku(goodSku);
        if (goodEntityList != null && !goodEntityList.isEmpty()) {
            return goodEntityList.get(0);
        }
        return null;
    }

    @Override
    public GoodEntity findGoodByNameAndSku(String goodName, String goodSku) {
        List<GoodEntity> goodEntityList = goodEntityMapper.selectGood(goodName, goodSku);
        if (goodEntityList != null && !goodEntityList.isEmpty()) {
            return goodEntityList.get(0);
        }
        return null;
    }

    @Override
    public boolean checkByNameAndSku(String goodName, String goodSku) {
        GoodEntity goodEntity = findGoodByNameAndSku(goodName, goodSku);
        return goodEntity == null ? false : true;
    }

    @Override
    public List<GoodEntity> findAllGoods() {
        List<GoodEntity> goodEntityList = goodEntityMapper.selectGood(null, null);
        return goodEntityList;
    }

    @Override
    public int addGood(GoodEntity goodEntity) {
        boolean isExist = checkByNameAndSku(goodEntity.getGoodName(),goodEntity.getGoodSku());
        if (isExist){
            return 0;
        }
        return goodEntityMapper.insert(goodEntity);
    }

    @Override
    public int update(GoodEntity goodEntity) {
        return goodEntityMapper.updateByPrimaryKeySelective(goodEntity);
    }

//
//    /**
//     * 添加商品
//     *
//     * @param dataBean
//     * @return 0-添加失败，1-添加成功
//     */
//    public int addGood(GoodsEntity dataBean) {
//        List<GoodsEntity> goods = goodsEntityMapper.selectGoods(dataBean);
//        if (goods != null && !goods.isEmpty() && (goods.get(0).getGoodName().equals(goods.get(0).getGoodName())
//                || dataBean.getGoodSku().equals(goods.get(0).getGoodSku()))) {
//            return 0;
//        }
//        dataBean.setGoodCreateDtime(new Date());
//        int status = goodsEntityMapper.insert(dataBean);
//        return 1;
//    }
//
//    public List<GoodsEntity> getGoods() {
//        List<GoodsEntity> goods = goodsEntityMapper.selectGoods(null);
//        return goods;
//    }
}
