package com.hzzl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/paramTest/")
@Controller
public class TestController {

    @RequestMapping(value = "param/{id}/{name")
    @ResponseBody
    public String getParam(@PathVariable("id") String id, @PathVariable("name")String name) {
        StringBuffer append = new StringBuffer().append(id).append(name);
        System.out.println(append.toString());
        return "111";
    }


    public static void main(String[] args) {


        List<Integer> list= new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for (int i = list.size(); i > 0 ; i--)
        {
            if(i>=2){
                Integer remove = list.remove(i-3);
                System.out.println(remove);
            }

        }

        /*for (int i = 0; i < list.size(); i++)
        {
            Integer remove = list.remove(i);
            System.out.println(remove);
        }*/
        /*while(list.size()>0){
            Integer remove = list.remove(list.size() - 1);
            System.out.println(remove);
        }*/
    }

}
