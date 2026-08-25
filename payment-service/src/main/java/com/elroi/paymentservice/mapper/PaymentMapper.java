package com.elroi.paymentservice.mapper;

import com.elroi.paymentservice.dto.PaymentDTO;
import com.elroi.paymentservice.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDTO toDTO(Payment payment) {
        if (payment == null) {
            return null;
        }
        return new PaymentDTO(
                payment.getId(),
                payment.getPatientId(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getPaymentMethod(),
                payment.getTransactionReference(),
                payment.getDescription()
        );
    }

    public Payment toEntity(PaymentDTO dto) {
        if (dto == null) {
            return null;
        }
        Payment payment = new Payment();
        payment.setId(dto.getId());
        payment.setPatientId(dto.getPatientId());
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setTransactionReference(dto.getTransactionReference());
        payment.setDescription(dto.getDescription());
        return payment;
    }

}
