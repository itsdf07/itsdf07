package com.itsdf07.service.impl;

import com.itsdf07.entity.UserEntity;
import com.itsdf07.mapper.UserEntityMapper;
import com.itsdf07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public UserEntity findUserByUserName(String username) {
        return findUserByUserNameAndPwd(username, null);
    }

    @Override
    public UserEntity findUserByUserNameAndPwd(String username, String pwd) {
        UserEntity entity = userEntityMapper.selectUser(username, pwd);
        return entity;
    }

    @Override
    public boolean checkByUserName(String username) {
        return checkByUserNameAndPwd(username, null);
    }

    @Override
    public boolean checkByUserNameAndPwd(String username, String pwd) {
        UserEntity entity = userEntityMapper.selectUser(username, pwd);
        return null == entity ? false : true;
    }
}
