package com.jhonnybooy.myapy.myapy.service;

import java.util.stream.Collectors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnybooy.myapy.myapy.dto.UserDTO;
import com.jhonnybooy.myapy.myapy.dto.UserResponseDTO;
import com.jhonnybooy.myapy.myapy.model.User;
import com.jhonnybooy.myapy.myapy.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getUser(Long id) {
    return userRepository.findById(id).get();
  }

  public User createUser(UserDTO userDTO) {
    User user = new User();
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    return userRepository.save(user);
  }

  public UserResponseDTO deleteUser(Long id) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    userRepository.deleteById(id);

    UserResponseDTO userResponseDTO = new UserResponseDTO(user.getId(), user.getName(), user.getEmail(),
        user.getCreatedAt(), user.getUpdatedAt());

    return userResponseDTO;
  }

  public UserResponseDTO updateUser(Long id, UserDTO userDTO) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    userRepository.save(user);

    UserResponseDTO userResponseDTO = new UserResponseDTO(user.getId(), user.getName(), user.getEmail(),
        user.getCreatedAt(), user.getUpdatedAt());
    return userResponseDTO;
  }

  public List<UserResponseDTO> getUsers() {
    List<UserResponseDTO> users = userRepository.findAll().stream()
        .map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(),
            user.getUpdatedAt()))
        .collect(Collectors.toList());
    return users;
  }
}
