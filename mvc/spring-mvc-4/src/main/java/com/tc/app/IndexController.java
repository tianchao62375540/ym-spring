package com.tc.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tianchao
 * @Date: 2020/2/21 23:36
 * @Description:
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index(){
        System.out.println("-----------index--------------");
        return "index";
    }
}
