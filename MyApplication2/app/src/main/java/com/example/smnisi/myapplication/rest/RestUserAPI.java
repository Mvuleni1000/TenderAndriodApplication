package com.example.smnisi.myapplication.rest;

import com.example.smnisi.myapplication.model.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smnisi on 2015/09/25.
 */
public class RestUserAPI implements RestAPIaddUser{

    final String BASE_URL="http://course-mvuleni.rhcloud.com/user/";
    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();


      @Override
    public String saveUser(User entity) {
        //DIRECT URL TO THIS SERVICE (API) ON BACKEND
        final String url = BASE_URL+"creatUser/";
        //CREATES READ/WRITE OBJECT
        HttpEntity<User> requestEntity = new HttpEntity<User>(entity, requestHeaders);

        try {
            //WRITES TO THE BACKED
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            //GETS RESPONSE FROM BACKED
            String result = responseEntity.getBody();
            return result;
        }catch (Exception e)
        {
            return "Exists";
        }
    }

        @Override
        public List<User> getAllUser() {
        final String url = BASE_URL + "view_users/";
        List<User> usersList = new ArrayList<>();
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<User[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
        User[] results = responseEntity.getBody();

        for (User users : results) {

            usersList.add(users);
        }

        return usersList;
    }
}
