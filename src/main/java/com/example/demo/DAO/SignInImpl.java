package com.example.demo.DAO;

import com.example.demo.Entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignInImpl implements UserService{
    private JdbcTemplate jdbcTemplate;

    SignInImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String username, String password) {
        return 0;
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
