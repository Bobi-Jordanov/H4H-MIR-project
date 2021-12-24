package com.example.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


@Repository
public class UserRepository {
    List<User> users = new ArrayList<>();

    public List<User> getUser() {
        users.add(User.builder().username("Pinch24").firstName("Bobi").lastName("Jordanov").email("bobi.j@hotmail.com").id(1).build());
        users.add(User.builder().username("Joki55").firstName("Jovan").lastName("Krt").email("jovan.k@hotmail.com").id(2).build());
        users.add(User.builder().username("KremBanana").firstName("Ana").lastName("Banana").email("ana.b@hotmail.com").id(3).build());

        return users;
    }

    public User findAllById(int id) {

        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return new User();
    }

    public User postUser(User usersV) {
        users.add(usersV);
        return usersV;
    }

    public String someString(String word) {
        return "Here is the string you entered: "+word;
    }

//    public ResponseEntity<Map<String, String>> createUser(String acceptHeader, String authorizationHeader) {
//        Map<String,String> returnValue=new HashMap<>();
//        returnValue.put("Accept", acceptHeader);
//        returnValue.put("Authorization", authorizationHeader);
//
//        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
//    }

    public ResponseEntity<Map<String, String>> createUser(String acceptHeader, String contentType) {
        Map<String,String> returnValue=new HashMap<>();
        returnValue.put("Accept", acceptHeader);
        returnValue.put("Content-type", contentType);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
}