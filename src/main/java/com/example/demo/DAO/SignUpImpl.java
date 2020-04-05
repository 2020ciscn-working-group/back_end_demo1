package com.example.demo.DAO;

import com.example.demo.Entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class SignUpImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    SignUpImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(@RequestParam String username, @RequestParam String password) {
        return jdbcTemplate.update("insert into demo1(username, password) values(?,?)",username,password);
    }

    @Override
    public List<UserEntity> getByName(String Username) {
        return null;
    }
}