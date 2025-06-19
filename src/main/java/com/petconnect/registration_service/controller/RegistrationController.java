package com.petconnect.registration_service.controller;

import com.petconnect.registration_service.model.UserRegistration;
import com.petconnect.registration_service.service.UserRegistrationService;
import com.petconnect.registration.dto.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

  @Autowired
  private UserRegistrationService registrationService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public UserRegistration registerUser(@RequestBody UserRegistrationRequest request) {

    // Convertir el DTO a la entidad UserRegistration
    UserRegistration userRegistration = new UserRegistration();
    userRegistration.setFullName(request.getFullName());
    userRegistration.setEmail(request.getEmail());
    userRegistration.setPassword(request.getPassword());

    // Llamar al servicio
    return registrationService.registerUser(userRegistration);
  }
}
