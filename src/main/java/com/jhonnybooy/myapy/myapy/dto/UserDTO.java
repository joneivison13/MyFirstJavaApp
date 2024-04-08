package com.jhonnybooy.myapy.myapy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email is invalid")
  private String email;

  @NotBlank(message = "Password is mandatory")
  @Size(min = 6, max = 40, message = "Password must be between 6 and 40 characters")
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
