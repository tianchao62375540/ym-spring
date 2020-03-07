package com.tc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 18:53
 * @Description:
 */
@Controller
public class IndexController {

    public IndexController(){
        System.out.println("init IndexController");
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        System.out.println("==============");
        return "hello mvc-boot";
    }
    @RequestMapping("/ttwwoo")
    @ResponseBody
    public String two(){
        System.out.println("==============");
        return "hello mvc-boot";
    }
}
