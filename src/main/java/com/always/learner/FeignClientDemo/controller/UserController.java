package com.always.learner.FeignClientDemo.controller;
import com.always.learner.FeignClientDemo.dto.User;
import com.always.learner.FeignClientDemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController
{
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/usr/{id}")
    public User user(@PathVariable("id") String id) {
        logger.info("User details based on id- {}",id);
        return userService.getUser(id);
    }
    @GetMapping("/usr_list")
    public List<User> getAllUser(){
        logger.info("access all user");
        return userService.getAllUser();
    }
    @PostMapping("/add_usr")
    public String addUser(@RequestBody User user) {
        logger.info("adding user...");
        return userService.addUser(user);
    }
    @PutMapping("/usr_data/{id}")
    public String updateUser(@PathVariable Long id,@RequestParam String address) {
        logger.info("updating user Id - {}",id);
        return userService.updateUser(id,address);
    }

    @DeleteMapping("/usr_remove/{id}")
    public String deleteUser(@PathVariable Long id) {
        logger.info("deleting record for Id  {} ",id);
        return userService.deleteUser(id);
    }

}
