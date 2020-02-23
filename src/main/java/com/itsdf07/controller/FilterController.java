package com.itsdf07.controller;

import com.itsdf07.author.VersionEntity;
import com.itsdf07.entity.AuthorEntity;
import com.itsdf07.bean.PingHostBean;
import com.itsdf07.entity.UserEntity;
import com.itsdf07.mapper.AuthorEntityMapper;
import com.itsdf07.service.UserService;
import com.itsdf07.service.impl.PingService;
import com.itsdf07.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 页面跳转过滤器
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/6
 */
@Controller
@RequestMapping(value = {""})
public class FilterController {
    @Autowired
    private AuthorEntityMapper authorEntityMapper;
    @Autowired
    private PingService pingService;
    @Autowired
    private UserService userService;

    @Value("${version}")
    private String version;
    @Value("${versionInfo}")
    private String versionInfo;
    //    @Resource
    @Autowired
    private VersionEntity versionEntity;

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
     * 访问作者页
     * 1:http://localhost:8087/itsdf07/
     * 2:http://localhost:8087/itsdf07/author
     * 3:http://localhost:8087/itsdf07/author.html
     *
     * @return 作者页
     */
    @RequestMapping(value = {"", "/", "author", "author.html"})
    public String doForward2Author(Model model) {
        AuthorEntity authorEntity = authorEntityMapper.getAuthor();
        if (null == authorEntity || authorEntity.getIsShow() == 0) {
            return "thymeleafHtml";
        }
        model.addAttribute("author", authorEntity);
        model.addAttribute("version", versionEntity);
        model.addAttribute("os", version);
        System.out.println("从yml中注解方式取得version:" + version + ",versionInfo" + versionInfo);
        return "author";
    }

    /**
     * Thymeleaf学习页，访问地址如下(多种访问方式)
     * 1:http://localhost:8087/itsdf07/
     * 2:http://localhost:8087/itsdf07/thymeleafHtml
     * 3:http://localhost:8087/itsdf07/thymeleafHtml.html
     *
     * @return 欢迎页
     */
    @RequestMapping(value = {"thymeleafHtml", "thymeleafHtml.html"})//value = {"", "",...}为多参数数据访问方式
    public String doForward2ThymeleafHtml() {
        System.out.println("do forward fixed ---> thymeleafHtml.html");
        return "thymeleafHtml";
    }

    /**
     * thymeleaf模板中html带参请求
     *
     * @param group 参数
     * @param model
     * @return
     */
    @RequestMapping("hosts")
    public String doDataFormThymeleafHtml(String group, Model model, HttpSession session) {
        System.out.println("do forward fixed ---> thymeleafHtml.html,group=" + group);
        List<PingHostBean> hosts = pingService.getHostsByGroup(group);
        model.addAttribute("group", "I'm in the " + group + " group");
        model.addAttribute("datas", hosts);
        return "thymeleafHtml2";
    }

    /**
     * thymeleaf模板中html占位符带参请求
     *
     * @param username 参数
     * @param group    参数
     * @param model
     * @return
     */
    @RequestMapping("/{username}/{group}/hosts")
    public String doDataFormThymeleafHtmlRest(@PathVariable String username, @PathVariable String group, Model model, HttpSession session) {
        System.out.println("username=" + username + ",group=" + group);
        session.setAttribute("username", username);
        return doDataFormThymeleafHtml(group, model, session);
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

    /**
     * 用户登录接口
     *
     * @return 登录之后的跳转页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String onLogin(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String loginId = request.getParameter("userName");
        String loginPwd = request.getParameter("password");
        UserEntity userEntity = userService.findUserByUserNameAndPwd(loginId, loginPwd);
        if (null == userEntity) {//登陆失败，则提示并返回登陆页
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
        return "redirect:/author";
    }


}
