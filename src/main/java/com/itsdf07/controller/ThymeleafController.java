package com.itsdf07.controller;

import com.itsdf07.bean.BaseRespBean;
import com.itsdf07.bean.PingHostBean;
import com.itsdf07.service.PingService;
import com.itsdf07.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * 通用跳转方式(不带参数)
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

    /**
     * Thymeleaf学习页，访问地址如下(多种访问方式)
     * 1:http://localhost:8087/itsdf07/
     * 2:http://localhost:8087/itsdf07/thymeleafHtml
     * 3:http://localhost:8087/itsdf07/thymeleafHtml.html
     *
     * @return 欢迎页
     */
    @RequestMapping(value = {"/", "thymeleafHtml", "thymeleafHtml.html"})//value = {"", "",...}为多参数数据访问方式
    public String doForward2ThymeleafHtml() {
        System.out.println("do forward fixed ---> thymeleafHtml.html");
        return "thymeleafHtml";
    }

    /**
     * thymeleaf模板中html带参请求
     *
     * @param name  参数
     * @param model
     * @return
     */
    @RequestMapping("thyDatas")
    public String doDataFormThymeleafHtml(String name, Model model, HttpSession session) {
        System.out.println("do forward fixed ---> thymeleafHtml.html,name=" + name);
        session.setAttribute("name", name);
        BaseRespBean baseRespBean = new BaseRespBean();
        baseRespBean.setCode(200);
        baseRespBean.setDesc("请求成功");
        model.addAttribute("message", "I am " + name + ",I like you!!!");
        model.addAttribute("respDatas", baseRespBean);
        return "thymeleafHtml2";
    }

    /**
     * thymeleaf模板中html占位符带参请求
     *
     * @param name  参数
     * @param pwd   参数
     * @param model
     * @return
     */
    @RequestMapping("/{name}/{pwd}/thyDatas")
    public String doDataFormThymeleafHtmlRest(@PathVariable String name, @PathVariable String pwd, Model model, HttpSession session) {
        System.out.println("name=" + name + ",pwd=" + pwd);
        return doDataFormThymeleafHtml(name, model, session);
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
