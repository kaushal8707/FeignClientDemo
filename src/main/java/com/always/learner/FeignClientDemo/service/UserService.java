package com.always.learner.FeignClientDemo.service;
import com.always.learner.FeignClientDemo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@FeignClient(name = "feignUserService", url = "http://localhost:8083/springDataDemo")
@FeignClient(name = "${service.name}", url = "${service.base.url}")
public interface UserService
{
    @GetMapping("/userdata/{id}")
    User getUser(@PathVariable("id") String id);

    @GetMapping("/users_data")
    public List<User> getAllUser();

    @PostMapping("/user_data")
    public String addUser(@RequestBody User user);

    @PutMapping("/user_data/{id}")
    public String updateUser(@PathVariable Long id,@RequestParam String address);

    @DeleteMapping("/user_remove_data/{id}")
    public String deleteUser(@PathVariable Long id);
}

