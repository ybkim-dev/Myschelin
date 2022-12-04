package project.myschelin.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.myschelin.domain.user.dto.UserInsertRequestDto;
import project.myschelin.domain.user.dto.UserResponseDto;
import project.myschelin.domain.user.service.UserService;

import java.net.URI;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<Void> enrollUser(@RequestBody UserInsertRequestDto userInsertRequestDto) {
        long userId = userService.saveUser(userInsertRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/users/" + userId)).build();
    }

    @GetMapping("/api/v1/users/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("userId") long userId) {
        UserResponseDto user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

}
