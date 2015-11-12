package com.example.smnisi.myapplication.services;

import com.example.smnisi.myapplication.model.User;

import java.util.List;

/**
 * Created by smnisi on 2015/09/25.
 */
public interface UserServices {

    public String saveUser(User entity);
    List<User> getAllUser();
}
