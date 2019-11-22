package com.itsdf07.mapper;

import com.itsdf07.entity.PingResultEntity;

public interface PingResultEntityMapper {
    int deleteByPrimaryKey(Integer prId);

    int insert(PingResultEntity record);

    int insertSelective(PingResultEntity record);

    PingResultEntity selectByPrimaryKey(Integer prId);

    int updateByPrimaryKeySelective(PingResultEntity record);

    int updateByPrimaryKey(PingResultEntity record);
}