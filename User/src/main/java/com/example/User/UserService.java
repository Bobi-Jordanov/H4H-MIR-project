package com.example.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {

        return userRepository.getUser();
    }


    public User getUserByIds(int id) {
        return userRepository.findAllById(id);
    }

    public User postUsers(User users) {
        return userRepository.postUser(users);
    }

    public String someStrings(String word) {
        return userRepository.someString(word);
    }

//    public ResponseEntity<Map<String, String>> createUsers(String acceptHeader, String authorizationHeader) {
//        return userRepository.createUser(acceptHeader, authorizationHeader);
//    }

    public ResponseEntity<Map<String, String>> createUsers(String acceptHeader, String contentType) {
        return userRepository.createUser(acceptHeader, contentType);
    }
}

