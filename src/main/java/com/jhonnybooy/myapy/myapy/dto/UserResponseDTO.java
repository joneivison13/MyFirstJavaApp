package com.jhonnybooy.myapy.myapy.dto;

import java.time.LocalDateTime;

public class UserResponseDTO {
  private Long id;
  private String name;
  private String email;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public UserResponseDTO(Long id, String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;

  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
}