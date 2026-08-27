package com.elroi.paymentservice.mapper;

import com.elroi.paymentservice.dto.PaymentRequestDto;
import com.elroi.paymentservice.dto.PaymentResponseDto;
import com.elroi.paymentservice.model.Payment;

import java.time.LocalDateTime;

public class PaymentMapper {

    public Payment toEntity(PaymentRequestDto paymentRequestDto) {
        if (paymentRequestDto == null) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();
        Payment payment = new Payment();
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setCurrency(paymentRequestDto.getCurrency());
        payment.setReference(paymentRequestDto.getReference());
        payment.setPaymentMethod(paymentRequestDto.getPaymentMethod());
        payment.setStatus(paymentRequestDto.getStatus());
        payment.setCreatedAt(now);
        payment.setUpdatedAt(now);
        return payment;
    }

    public PaymentResponseDto toDto(Payment payment) {
        if (payment == null) {
            return null;
        }

        return new PaymentResponseDto(
                payment.getId(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getReference(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getCreatedAt(),
                payment.getUpdatedAt()
        );
    }
}
