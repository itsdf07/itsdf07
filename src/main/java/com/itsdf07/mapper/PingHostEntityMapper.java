package com.itsdf07.mapper;

import com.itsdf07.bean.PingHostBean;
import com.itsdf07.entity.PingHostEntity;
import com.itsdf07.entity.PingResultEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PingHostEntityMapper {
    /**
     * 根据目标主机的归类，查询对应主机
     * 如果归类为空，这查找全部
     *
     * @param group 目标主机的归类
     * @return
     */
    List<PingHostBean> selectByGroup(String group);

    int deleteByPrimaryKey(Integer phId);

    int insert(PingHostEntity record);

    int insertSelective(PingHostEntity record);

    PingHostEntity selectByPrimaryKey(Integer phId);

    int updateByPrimaryKeySelective(PingHostEntity record);

    int updateByPrimaryKey(PingHostEntity record);
}