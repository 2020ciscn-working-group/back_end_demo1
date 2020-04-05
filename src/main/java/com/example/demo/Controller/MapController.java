package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MapController {
    @RequestMapping("/login")
    public String hey(){
        return "/login";
    }

    @RequestMapping("/test")
    public String test(){
        return "/test";
    }

    @RequestMapping("/signup")
    public String signUp(){
        return "/signup";
    }
}
