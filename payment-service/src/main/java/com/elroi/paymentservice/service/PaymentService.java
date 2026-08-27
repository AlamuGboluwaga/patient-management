package com.elroi.paymentservice.service;

import com.elroi.paymentservice.dto.PaymentRequestDto;
import com.elroi.paymentservice.dto.PaymentResponseDto;
import com.elroi.paymentservice.mapper.PaymentMapper;
import com.elroi.paymentservice.model.Payment;
import com.elroi.paymentservice.repository.PaymentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentResponseDto createPayment(@Valid @RequestBody PaymentRequestDto requestDto) {
        PaymentMapper paymentMapper = new PaymentMapper();
        Payment payment = paymentMapper.toEntity(requestDto);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDto(savedPayment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public PaymentResponseDto getPaymentByReference(String reference) {
        Payment payment = paymentRepository.findByReference(reference)
                .orElseThrow(() -> new IllegalArgumentException("Payment with reference " + reference + " not found"));
        return new PaymentMapper().toDto(payment);
    }

    public String deletePaymentByReference(String reference) {
        Payment payment = paymentRepository.findByReference(reference)
                .orElseThrow(() -> new IllegalArgumentException("Payment with reference " + reference + " not found"));
        paymentRepository.delete(payment);
        return "Payment with reference " + reference + " has been deleted successfully";
    }

    public PaymentResponseDto updatePayment(String reference, PaymentRequestDto requestDto) {
        Payment payment = paymentRepository.findByReference(reference)
                .orElseThrow(() -> new IllegalArgumentException("Payment with reference " + reference + " not found"));

        payment.setAmount(requestDto.getAmount());
        payment.setCurrency(requestDto.getCurrency());
        payment.setReference(requestDto.getReference());
        payment.setPaymentMethod(requestDto.getPaymentMethod());
        payment.setStatus(requestDto.getStatus());
        payment.setUpdatedAt(LocalDateTime.now());

        Payment updatedPayment = paymentRepository.save(payment);
        return new PaymentMapper().toDto(updatedPayment);
    }
}
