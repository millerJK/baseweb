package com.base.electric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping("/hello.json")
    public void hello(HttpServletResponse response){
        try {
            response.getWriter().print("hello,world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
