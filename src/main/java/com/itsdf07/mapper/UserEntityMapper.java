package com.itsdf07.mapper;

import com.itsdf07.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserEntityMapper {
    /**
     * 根据账户、密码查询用户
     *
     * @param username
     * @param passwd
     * @return
     */
    UserEntity selectUser(@Param("username") String username, @Param("pwd") String passwd);

    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}