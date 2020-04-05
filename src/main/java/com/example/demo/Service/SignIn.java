package com.example.demo.Service;

import com.example.demo.DAO.SignInImpl;
import com.example.demo.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignIn {
    @Autowired
    SignInImpl si;

    @PostMapping("/login")
    public String SignIn(@RequestParam String username, @RequestParam String password){
        List<UserEntity> user = si.getByName(username);
        String userStr = user.toString(); //输出前后带有[], 只好在UserEntity重写方法时前后加空格然后正则去除
        String[] str = userStr.split("\\s");//str[0]='[], str[1]=uid, str[2]=username, str[3]=pwd
        String confpassword = str[3];
        if(confpassword.equals(password)){
            return "/success";
        }
        else {
            return userStr;
        }
    }
}
