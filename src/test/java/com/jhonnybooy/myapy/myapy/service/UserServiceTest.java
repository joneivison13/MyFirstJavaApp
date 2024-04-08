package com.jhonnybooy.myapy.myapy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jhonnybooy.myapy.myapy.dto.UserDTO;
import com.jhonnybooy.myapy.myapy.dto.UserResponseDTO;
import com.jhonnybooy.myapy.myapy.model.User;
import com.jhonnybooy.myapy.myapy.repository.UserRepository;
import com.jhonnybooy.myapy.myapy.service.UserService;

public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetUser() {
    Long userId = 1L;
    User user = new User();
    user.setId(userId);
    user.setName("John");
    user.setEmail("john@example.com");
    user.setPassword("password");

    when(userRepository.findById(userId)).thenReturn(Optional.of(user));

    User result = userService.getUser(userId);

    assertEquals(user, result);
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

    when(userRepository.save(any(User.class))).thenReturn(user);

    User result = userService.createUser(userDTO);

    assertEquals(user, result);
  }

  @Test
  public void testDeleteUser() {
    Long userId = 1L;
    User user = new User();
    user.setId(userId);
    user.setName("John");
    user.setEmail("john@example.com");
    user.setPassword("password");

    when(userRepository.findById(userId)).thenReturn(Optional.of(user));

    UserResponseDTO result = userService.deleteUser(userId);

    assertEquals(userId, result.getId());
    assertEquals(user.getName(), result.getName());
    assertEquals(user.getEmail(), result.getEmail());
    assertEquals(user.getCreatedAt(), result.getCreatedAt());
    assertEquals(user.getUpdatedAt(), result.getUpdatedAt());

    verify(userRepository, times(1)).deleteById(userId);
  }

  @Test
  public void testUpdateUser() {
    Long userId = 1L;
    UserDTO userDTO = new UserDTO();
    userDTO.setName("John");
    userDTO.setEmail("john@example.com");
    userDTO.setPassword("password");

    User user = new User();
    user.setId(userId);
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());

    when(userRepository.findById(userId)).thenReturn(Optional.of(user));
    when(userRepository.save(user)).thenReturn(user);

    UserResponseDTO result = userService.updateUser(userId, userDTO);

    assertEquals(userId, result.getId());
    assertEquals(user.getName(), result.getName());
    assertEquals(user.getEmail(), result.getEmail());
    assertEquals(user.getCreatedAt(), result.getCreatedAt());
    assertEquals(user.getUpdatedAt(), result.getUpdatedAt());
  }

  @Test
  public void testGetUsers() {
    User user1 = new User();
    user1.setId(1L);
    user1.setName("John");
    user1.setEmail("john@example.com");
    user1.setPassword("password");

    User user2 = new User();
    user2.setId(2L);
    user2.setName("Jane");
    user2.setEmail("jane@example.com");
    user2.setPassword("password");

    List<User> userList = new ArrayList<>();
    userList.add(user1);
    userList.add(user2);

    when(userRepository.findAll()).thenReturn(userList);

    List<UserResponseDTO> result = userService.getUsers();

    assertEquals(2, result.size());
    assertEquals(user1.getId(), result.get(0).getId());
    assertEquals(user1.getName(), result.get(0).getName());
    assertEquals(user1.getEmail(), result.get(0).getEmail());
    assertEquals(user1.getCreatedAt(), result.get(0).getCreatedAt());
    assertEquals(user1.getUpdatedAt(), result.get(0).getUpdatedAt());
    assertEquals(user2.getId(), result.get(1).getId());
    assertEquals(user2.getName(), result.get(1).getName());
    assertEquals(user2.getEmail(), result.get(1).getEmail());
    assertEquals(user2.getCreatedAt(), result.get(1).getCreatedAt());
    assertEquals(user2.getUpdatedAt(), result.get(1).getUpdatedAt());
  }

  @Test
  public void testGetUserNotFound() {
    Long userId = 1L;

    when(userRepository.findById(userId)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> userService.getUser(userId));
  }

  @Test
  public void testDeleteUserNotFound() {
    Long userId = 1L;

    when(userRepository.findById(userId)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> userService.deleteUser(userId));
  }

  @Test
  public void testUpdateUserNotFound() {
    Long userId = 1L;
    UserDTO userDTO = new UserDTO();
    userDTO.setName("John");
    userDTO.setEmail("john@example.com");
    userDTO.setPassword("password");

    when(userRepository.findById(userId)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> userService.updateUser(userId, userDTO));
  }

}