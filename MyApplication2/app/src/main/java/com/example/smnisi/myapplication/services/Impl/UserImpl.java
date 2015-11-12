package com.example.smnisi.myapplication.services.Impl;

import com.example.smnisi.myapplication.model.User;
import com.example.smnisi.myapplication.rest.RestAPIaddUser;
import com.example.smnisi.myapplication.rest.RestUserAPI;
import com.example.smnisi.myapplication.services.UserServices;

import java.util.List;

/**
 * Created by smnisi on 2015/09/25.
 */
public class UserImpl  implements UserServices {


        final RestAPIaddUser rest = new RestUserAPI();

        @Override
        public String saveUser(User entity) {
            return  rest.saveUser(entity);
        }

        @Override
        public List<User> getAllUser() {
            return rest.getAllUser();
        }
  }


