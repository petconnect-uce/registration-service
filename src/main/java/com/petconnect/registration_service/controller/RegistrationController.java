
package com.petconnect.registration_service.controller;

import com.petconnect.registration_service.model.UserRegistration;
import com.petconnect.registration_service.service.UserRegistrationService;
import com.petconnect.registration_service.dto.UserRegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
public class RegistrationController {

  @Autowired
  private UserRegistrationService registrationService;

  @PostMapping(value = "/register", consumes = "application/json", produces = "application/json") // <--- Añadido el
                                                                                                  // path
  public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request) {
    if (request.getEmail() == null || request.getPassword() == null || request.getFullName() == null) {
      return ResponseEntity.badRequest().body("Missing required fields");
    }

    UserRegistration userRegistration = new UserRegistration();
    userRegistration.setFullName(request.getFullName());
    userRegistration.setEmail(request.getEmail());
    userRegistration.setPassword(request.getPassword());

    return ResponseEntity.ok(registrationService.registerUser(userRegistration));
  }

  @GetMapping("/test-protected")
  public ResponseEntity<?> testProtected() {
    return ResponseEntity.ok("Access granted to protected resource");
  }
}
