package com.petconnect.registration_service.service;

import com.petconnect.registration_service.model.UserRegistration;
import com.petconnect.registration_service.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepository registrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserRegistration registerUser(UserRegistration userRegistration) {

        // Validar si el email ya existe
        if (registrationRepository.findByEmail(userRegistration.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está en uso.");
        }

        // Encriptar el password
        String encodedPassword = passwordEncoder.encode(userRegistration.getPassword());
        userRegistration.setPassword(encodedPassword);

        // Guardar en base de datos
        return registrationRepository.save(userRegistration);
    }
}
