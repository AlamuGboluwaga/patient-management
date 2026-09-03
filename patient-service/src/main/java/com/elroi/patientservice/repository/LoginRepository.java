package com.elroi.patientservice.repository;

import com.elroi.patientservice.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<Login, UUID> {
    Optional<Login> findByEmailAndPassword(String email, String password);

    Optional<String> findByEmail(String email);

}
