package com.petconnect.registration_service.service;

import com.petconnect.registration_service.model.UserRegistration;
import com.petconnect.registration_service.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistration registerUser(UserRegistration userRegistration) {
        return userRegistrationRepository.save(userRegistration);
    }
}
