package com.xjy.shiro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class TestJDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/testGetAllUser")
    public String testGetAllUser(Model model){
        String sql = "select * from user";
        List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
        model.addAttribute("testGetAllUser",map);
        return "/test";
    }
}
