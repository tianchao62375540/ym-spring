package com.tc.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 12:34
 * @Description:
 */
@Controller
public class IndexController {
    @RequestMapping("upload")
    public void upload(@RequestParam("tianchao") MultipartFile file){
        System.out.println(file);
    }
}
