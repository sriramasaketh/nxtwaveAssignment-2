package com.usermanagement.controller;

import com.usermanagement.dto.UserRequest;
import com.usermanagement.exception.CustomException;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public String createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/get_users")
    public Object getUsers(@RequestParam(required = false) String userId,
            @RequestParam(required = false) String mobNum,
            @RequestParam(required = false) String managerId) {
        return userService.getUsers(userId, mobNum, managerId);
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam(required = false) String userId,
            @RequestParam(required = false) String mobNum) {
        return userService.deleteUser(userId, mobNum);
    }

    @PostMapping("/update_user")
    public String updateUser(@RequestBody UserRequest request) {
        return userService.updateUser(request);
    }
}
