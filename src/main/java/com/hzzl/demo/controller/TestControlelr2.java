package com.hzzl.demo.controller;

import com.hzzl.demo.Annotation.CheckCach;
import com.hzzl.demo.abstractdemo.ApplicationContextProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @CheckCach(value="CheckCach2019/4/4")
    public String getData(){
        ApplicationContextProvider.getBean("");
        return "test";
    }
}
