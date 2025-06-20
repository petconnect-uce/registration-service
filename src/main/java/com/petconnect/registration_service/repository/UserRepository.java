package com.petconnect.registration_service.repository;

import com.petconnect.registration_service.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRegistration, Long> {

    Optional<UserRegistration> findByEmail(String email);
}
