package com.example.demo.Service;


import com.example.demo.DAO.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUp {

    @Autowired
    UserServiceImpl sui;
    /**
     *
     * @param username
     * @param password
     * @param confpassword
     * @return
     */
    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password, @RequestParam String confpassword){
        if(password.equals(confpassword)){
            sui.create(username, password);
            return "/success";
        }
        else{
            //return password+confpassword;
            return "密码输错了别注册了回家洗洗睡吧";
        }
    }
}
