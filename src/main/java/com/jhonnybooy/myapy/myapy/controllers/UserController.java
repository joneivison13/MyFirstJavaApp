package com.jhonnybooy.myapy.myapy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonnybooy.myapy.myapy.dto.UserDTO;
import com.jhonnybooy.myapy.myapy.dto.UserResponseDTO;
import com.jhonnybooy.myapy.myapy.model.User;
import com.jhonnybooy.myapy.myapy.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.createUser(userDTO));
  }

  @GetMapping("/all")
  public ResponseEntity<Iterable<UserResponseDTO>> getUsers() {
    List<UserResponseDTO> users = userService.getUsers();
    return ResponseEntity.ok(users);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<UserResponseDTO> updateUsers(@PathVariable String id,
      @RequestBody UserDTO data) {
    return ResponseEntity.ok(userService.updateUser(Long.parseLong(id), data));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
    UserResponseDTO userResponseDTO = userService.deleteUser(id);
    return ResponseEntity.ok(userResponseDTO);
  }

}
