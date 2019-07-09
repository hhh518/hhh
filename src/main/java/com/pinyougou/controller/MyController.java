package com.pinyougou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String index(){
        return "manager/admin/type_template";
    }
    @RequestMapping("/test")
    public String login1(){
        return "manager/admin/specification";
    }




}
