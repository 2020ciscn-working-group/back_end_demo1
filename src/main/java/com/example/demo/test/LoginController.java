package com.example.demo.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/hey")
    public String loginController(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username+password);
        return "success";
    }
}
