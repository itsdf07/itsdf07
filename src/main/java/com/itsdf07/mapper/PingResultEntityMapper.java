package com.itsdf07.mapper;

import com.itsdf07.entity.PingResultEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PingResultEntityMapper {

    int insertBatch(@Param("pingResults")List<PingResultEntity> pingResults);

    int deleteByPrimaryKey(Integer prId);

    int insert(PingResultEntity record);

    int insertSelective(PingResultEntity record);

    PingResultEntity selectByPrimaryKey(Integer prId);

    int updateByPrimaryKeySelective(PingResultEntity record);

    int updateByPrimaryKey(PingResultEntity record);
}