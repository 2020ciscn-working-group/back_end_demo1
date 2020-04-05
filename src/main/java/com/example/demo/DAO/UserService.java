package com.example.demo.DAO;

import com.example.demo.Entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    int create(String username, String password);

    /**
     *
     * @param Username
     * @return
     */
    List<UserEntity> getByName(String Username);
}
