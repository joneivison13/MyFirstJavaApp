package com.jhonnybooy.myapy.myapy.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jhonnybooy.myapy.myapy.dto.UserDTO;
import com.jhonnybooy.myapy.myapy.dto.UserResponseDTO;
import com.jhonnybooy.myapy.myapy.model.User;
import com.jhonnybooy.myapy.myapy.service.UserService;

public class UserControllerTest {

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController userController;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCreateUser() {
    UserDTO userDTO = new UserDTO();
    userDTO.setName("John");
    userDTO.setEmail("john@example.com");
    userDTO.setPassword("password");

    User user = new User();
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());

    when(userService.createUser(userDTO)).thenReturn(user);

    ResponseEntity<User> response = userController.createUser(userDTO);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(user, response.getBody());
  }

  @Test
  public void testGetUsers() {
    UserResponseDTO user1 = new UserResponseDTO(1L, "John", "jhon@example.com", null, null);

    UserResponseDTO user2 = new UserResponseDTO(2L, "Jane", "jane@example.com", null, null);

    List<UserResponseDTO> userList = new ArrayList<>();
    userList.add(user1);
    userList.add(user2);

    when(userService.getUsers()).thenReturn(userList);

    ResponseEntity<Iterable<UserResponseDTO>> response = userController.getUsers();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(userList, response.getBody());
  }

  @Test
  public void testUpdateUser() {
    Long userId = 1L;
    UserDTO userDTO = new UserDTO();
    userDTO.setName("John");
    userDTO.setEmail("john@example.com");
    userDTO.setPassword("password");

    UserResponseDTO userResponseDTO = new UserResponseDTO(userId, userDTO.getName(), userDTO.getEmail(), null, null);

    when(userService.updateUser(userId, userDTO)).thenReturn(userResponseDTO);

    ResponseEntity<UserResponseDTO> response = userController.updateUsers(userId.toString(), userDTO);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(userResponseDTO, response.getBody());
  }

  @Test
  public void testDeleteUser() {
    Long userId = 1L;
    UserResponseDTO userResponseDTO = new UserResponseDTO(userId, "John", "john@example.com", null, null);

    when(userService.deleteUser(userId)).thenReturn(userResponseDTO);

    ResponseEntity<UserResponseDTO> response = userController.deleteUser(userId);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(userResponseDTO, response.getBody());
  }
}