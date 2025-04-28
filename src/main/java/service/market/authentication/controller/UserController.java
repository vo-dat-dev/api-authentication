package service.market.authentication.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.market.authentication.dto.CreateUserDTO;
import service.market.authentication.dto.UpdateUserDTO;
import service.market.authentication.entity.User;
import service.market.authentication.service.UserService;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "User API")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserDetail(@PathVariable Long userId) {
        User user = this.userService.getUserDetail(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO user) {
        User newUser = this.userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/user/update")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDTO user) {
        User updateUser = this.userService.updateUser(user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        User deleteUser = this.userService.deleteUser(userId);
        return ResponseEntity.ok(deleteUser);
    }
}
