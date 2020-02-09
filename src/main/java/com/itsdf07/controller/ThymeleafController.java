package com.itsdf07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 学习SpringBoot + Thymeleaf 实现前后端分离项目时记录以及沉淀
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/6
 */
@Controller
@RequestMapping(value = {""})
public class ThymeleafController {
    /**
     * Thymeleaf学习页，访问地址如下(多种访问方式)
     * 1:http://localhost:8087/itsdf07/
     * 2:http://localhost:8087/itsdf07/thymeleafHtml
     * 3:http://localhost:8087/itsdf07/thymeleafHtml.html
     *
     * @return 欢迎页
     */
    @RequestMapping(value = {"/", "thymeleafHtml", "thymeleafHtml.html"})//value = {"", "",...}为多参数数据访问方式
    public String thymeleafHtml() {
        System.out.println("do forward fixed ---> thymeleafHtml.html");
        return "thymeleafHtml";
    }


    /**
     * 通用跳转方式
     * http://localhost:8087/*
     * 其中*可代表任何字符串内容
     *
     * @return 欢迎页
     */
    @RequestMapping("/*")
    public String doForward(HttpServletRequest request) {
        String forward = request.getServletPath();
        System.out.println("doForward ---> " + forward);
        return forward;
    }
//
//    /**
//     * 跳转到用户登录页面:http://localhost:8087/itsdf07/tlogin
//     *
//     * @return 登录页面
//     */
//    @RequestMapping(value = "thymeleafDemo", method = RequestMethod.GET)
//    public String html2ThymeleafDemo(Model model) {
//        model.addAttribute("msg", "我是一个Thymeleaf模板静态页面测试页");
//        return "thymeleafHtml";
//    }
//
//    /**
//     * 跳转到用户登录页面:http://localhost:8087/itsdf07/tlogin
//     *
//     * @return 登录页面
//     */
//    @RequestMapping(value = "/tlogin", method = RequestMethod.GET)
//    public String onLogin(Model model) {
//        model.addAttribute("msg", "登陆系统UI实例");
//        return "login";
//    }


}
