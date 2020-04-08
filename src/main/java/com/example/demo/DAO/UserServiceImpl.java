package com.example.demo.DAO;

import com.example.demo.Entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(@RequestParam String username, @RequestParam String password) {
        return jdbcTemplate.update("insert into demo1(username, password) values(?,?)",username,password);
    }

    @Override
    public List<UserEntity> getByName(String username){
        List<UserEntity> users = jdbcTemplate.query("select uid, username, password from demo1 where username = ?", (resultSet, i) -> {
            UserEntity user = new UserEntity();
            user.setUid(resultSet.getString("uid"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }, username);
        return users;
    }
}
