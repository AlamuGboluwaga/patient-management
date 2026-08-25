package com.elroi.paymentservice.repository;

import com.elroi.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByPatientId(Long patientId);

    Optional<Payment> findByTransactionReference(String transactionReference);

    List<Payment> findByStatus(String status);

}
