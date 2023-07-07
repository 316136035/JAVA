package com.cn.controller;


import com.alibaba.fastjson.JSONArray;
import com.cn.oom.User1;
import com.cn.service.UserService1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller //允许交给组件扫描 控制器调度员
/**同等于http://localhost:9090/shen/*/
@RequestMapping("/user")
public class MyController1 {
    @Autowired
    @Qualifier("UserService1Impl")
    private UserService1Impl userService1;


    @GetMapping("/selectUserList")
    public String selectUserList(Model model){
        List<User1> user1s = userService1.SelectUser();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(user1s);
        model.addAttribute("user1s",jsonArray.toJSONString());

        return "mycontroller1";
    }
}
