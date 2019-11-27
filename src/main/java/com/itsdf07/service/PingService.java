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

    public List<PingHostBean> getHostsByGroup(String group) {
        return pingHostEntityMapper.selectByGroup(group);
    }

    public int insertBatch2PingResults(List<PingResultEntity> pingResults) {
        return pingResultEntityMapper.insertBatch(pingResults);
    }

}
