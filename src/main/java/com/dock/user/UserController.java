package com.dock.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    record User(int id, String name, int age){}
    static List<User> users = new ArrayList<User>();
    static {
        users.add(new User(1, "John", 28));
        users.add(new User(2, "Jane", 29));
        users.add(new User(3, "Bob", 28));
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }
    @GetMapping("/health")
    public String health(){
        return "OK";
    }
}
