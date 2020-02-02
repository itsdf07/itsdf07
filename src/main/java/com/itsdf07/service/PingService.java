package com.itsdf07.service;

import com.itsdf07.bean.PingHostBean;
import com.itsdf07.entity.PingHostEntity;
import com.itsdf07.entity.PingResultEntity;
import com.itsdf07.mapper.PingHostEntityMapper;
import com.itsdf07.mapper.PingResultEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
