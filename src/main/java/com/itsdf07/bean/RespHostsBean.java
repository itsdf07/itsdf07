package com.itsdf07.bean;

import java.util.List;

/**
 * @Description: 应app端的目标主机列表请求信息
 * @Auther: itsdf07
 * @Date: 2019/11/25 10:31
 **/
public class RespHostsBean extends BaseRespBean {
    private List<PingHostBean> datas;

    public List<PingHostBean> getDatas() {
        return datas;
    }

    public void setDatas(List<PingHostBean> datas) {
        this.datas = datas;
    }
}
