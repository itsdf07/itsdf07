package com.itsdf07.bean;

import com.itsdf07.entity.GoodEntity;

import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/3/6
 */
public class RespGoodsBean extends BaseRespBean {
    private List<GoodEntity> datas;

    public List<GoodEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<GoodEntity> datas) {
        this.datas = datas;
    }
}
