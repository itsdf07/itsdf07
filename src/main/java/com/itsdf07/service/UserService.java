package com.itsdf07.service;

import com.itsdf07.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/23
 */
public interface UserService {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    UserEntity findUserByUserName(String username);

    /**
     * 根据用户名和密码查找用户
     *
     * @param username
     * @return
     */
    UserEntity findUserByUserNameAndPwd(String username, String pwd);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    boolean checkByUserName(String username);

    /**
     * 根据用户名和密码查找用户
     *
     * @param username
     * @return
     */
    boolean checkByUserNameAndPwd(String username, String pwd);
}
