package com.itsdf07.service.impl;

import com.itsdf07.bean.PingHostBean;
import com.itsdf07.entity.PingHostEntity;
import com.itsdf07.entity.PingResultEntity;
import com.itsdf07.mapper.PingHostEntityMapper;
import com.itsdf07.mapper.PingResultEntityMapper;
import com.itsdf07.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: itsdf07
 * @Date: 2019/11/22 17:52
 **/
@Service
public class PingService {
    @Autowired
    private PingResultEntityMapper pingResultEntityMapper;
    @Autowired
    private PingHostEntityMapper pingHostEntityMapper;

    /**
     * 获取分类主机地址
     *
     * @param group 主机分类，如TTS，如果为空，则查询全部
     * @return
     */
    public List<PingHostBean> getHostsByGroup(String group) {
        return pingHostEntityMapper.selectByGroup(group);
    }

    /**
     * 批量插入数据
     *
     * @param pingResults
     * @return
     */
    public int insertBatch2PingResults(List<PingResultEntity> pingResults) {
        return pingResultEntityMapper.insertBatch(pingResults);
    }

    /**
     * 插入数据
     *
     * @param host  域名/IP
     * @param group 分组
     * @return 返回插入数量
     */
    public int insertHost(String host, String group) {
        PingHostEntity hostFormDB = pingHostEntityMapper.selectByHost(host);
        if (null != hostFormDB) {
            return 0;
        }
        PingHostEntity pingHostEntity = new PingHostEntity();
        pingHostEntity.setPhHost(host);
        pingHostEntity.setPhGroup(group);

        pingHostEntity.setPhCreateDate(new Date());
        return pingHostEntityMapper.insert(pingHostEntity);
    }

}
