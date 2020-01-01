package com.xjy.shiro.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author xiajiying
 */
@Controller
public class UserController {


    @RequestMapping("/hello")
    public String hello(){
        System.out.println("UserController.hello()");
        return "ok";
    }

    @RequestMapping("/main")
    public String testThymeleaf(Model model){
        model.addAttribute("name","xiajiying");
        return "main";
    }

    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/user/login";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/noAuth";
    }

    @RequestMapping("/ok")
    public String ok(){
        return "/ok";
    }

    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        //1、获取subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        System.out.println("login()===Start===");
        //3、执行登录方法
        try {
            subject.login(token);
            System.out.println("login()===Stop===");
            return "redirect:/main";
        }catch (UnknownAccountException e){
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            System.out.println("login()===Stop2===");
            return "/user/login";
        }catch (IncorrectCredentialsException e){
            //登录失败：密码错误
            model.addAttribute("msg","密码错误");
            System.out.println("login()===Stop3===");
            return "/user/login";
        }
    }
}
