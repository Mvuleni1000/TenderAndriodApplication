package com.example.smnisi.myapplication.rest;

import com.example.smnisi.myapplication.model.User;

import java.util.List;

/**
 * Created by smnisi on 2015/09/25.
 */
public interface RestAPIaddUser {

    public String saveUser(User entity);
    List<User> getAllUser();
}
