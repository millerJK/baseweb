package com.base.electric.controller;

import com.base.electric.domain.ElecUser;
import com.base.electric.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/userCenter")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("doLogin.json")
    public ModelAndView hello(@RequestParam("name") String username, @RequestParam("password") String password, HttpSession session) {
        ElecUser user = userService.findUserByNameAndPwd(username, password);
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            session.setAttribute("userNow", user);
            modelAndView.setViewName("menu/home");
        } else {
            modelAndView.addObject("errorInfo", "用户名或密码有误");
            modelAndView.setViewName("menu/index");
        }
        return modelAndView;
    }
}
