package com.elroi.patientservice.repository;

import com.elroi.patientservice.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, UUID> {
}
