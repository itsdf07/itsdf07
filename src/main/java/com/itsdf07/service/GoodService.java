package com.itsdf07.service;

import com.itsdf07.entity.GoodEntity;

import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/3/2
 */
public interface GoodService {
    /**
     * 根据商品名称查找
     *
     * @param goodName
     * @return
     */
    GoodEntity findGoodByName(String goodName);

    /**
     * 根据商品的Sku查找
     *
     * @param goodSku
     * @return
     */
    GoodEntity findGoodBySku(String goodSku);

    /**
     * 根据商品命名和商品Sku查找
     *
     * @param goodName
     * @param goodSku
     * @return
     */
    GoodEntity findGoodByNameAndSku(String goodName, String goodSku);

    /**
     * 根据商品命名和商品Sku校验是否存在
     *
     * @param goodName
     * @param goodSku
     * @return
     */
    boolean checkByNameAndSku(String goodName, String goodSku);

    /**
     * 查找所有商品
     *
     * @return
     */
    List<GoodEntity> findAllGoods();

    /**
     * 添加商品
     *
     * @return
     */
    int addGood(GoodEntity goodEntity);

}
