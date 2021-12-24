package com.example.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:8080")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody List<User> getUser() {
        return userService.getUsers();
    }

//    @GetMapping(value="/{id}")
//    public @ResponseBody User getUserById(@PathVariable int id) {
//        return userService.getUserByIds(id);
//    }

    @PostMapping(consumes="application/png")
    public @ResponseBody User postUser(@RequestBody User users) {
        return userService.postUsers(users);
    }

    @PostMapping(value = "/{word}")
    public String someString(@PathVariable String word) {
        return userService.someStrings(word);
    }

//    @PostMapping()
//    public ResponseEntity<Map<String, String>> createUser(@RequestHeader(value="Accept") String acceptHeader,
//        @RequestHeader(value="Authorization") String authorizationHeader){
//
//        return userService.createUsers(acceptHeader, authorizationHeader);
//    }

//    @PostMapping()
//    public ResponseEntity<Map<String, String>> createUser(@RequestHeader(value="Accept") String acceptHeader,
//                                                          @RequestHeader(value="Content-type") String contentType){
//
//        return userService.createUsers(acceptHeader, contentType);
//    }


}
