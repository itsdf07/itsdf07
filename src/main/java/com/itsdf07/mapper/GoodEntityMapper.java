package com.itsdf07.mapper;

import com.itsdf07.entity.GoodEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodEntityMapper {
    List<GoodEntity> selectGood(@Param("goodName") String goodName, @Param("goodSku") String goodSku);

    List<GoodEntity> selectGoodBySku(@Param("goodSku") String goodSku);

    int deleteByPrimaryKey(Integer goodId);

    int insert(GoodEntity record);

    int insertSelective(GoodEntity record);

    GoodEntity selectByPrimaryKey(Integer goodId);

    int updateByPrimaryKeySelective(GoodEntity record);

    int updateByPrimaryKey(GoodEntity record);
}