package com.hzzl.demo.controller;

import com.hzzl.demo.Annotation.CheckCach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: com.hzzl.demo.controller.TestControlelr2
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 2019/4/3 18:10
 */
@Controller
@RequestMapping("/test/")
public class TestControlelr2 {

    @RequestMapping("getData")
    @ResponseBody
    @CheckCach
    public String getData(ModelAndView mv){
        mv.addObject("test");
        System.out.println("TestControlelr2.....getData......");
        return "test";
    }
}
