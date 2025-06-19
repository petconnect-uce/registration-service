package com.petconnect.registration.dto;

import jakarta.validation.constraints.*;

public class UserRegistrationRequest {

  @NotBlank
  private String fullName;

  @Email
  @NotBlank
  private String email;

  @Size(min = 8)
  private String password;

  // Getters y Setters
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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
