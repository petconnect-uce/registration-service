package com.petconnect.registration_service.controller;

import com.petconnect.registration_service.model.UserRegistration;
import com.petconnect.registration_service.service.UserRegistrationService;
import com.petconnect.registration_service.dto.UserRegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegistrationController {

  @Autowired
  private UserRegistrationService registrationService;

  // Endpoint para registrar usuario (abierto)
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

  // Endpoint protegido con JWT para probar autenticación
  @GetMapping("/test-protected")
  public ResponseEntity<?> testProtected(@AuthenticationPrincipal UserDetails userDetails) {
    Map<String, Object> response = new HashMap<>();
    response.put("message", "Acceso permitido al endpoint protegido!");
    response.put("user", userDetails != null ? userDetails.getUsername() : "desconocido");

    return ResponseEntity.ok(response);
  }
}
