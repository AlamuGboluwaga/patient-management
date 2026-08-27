package com.elroi.paymentservice.controller;

import com.elroi.paymentservice.dto.PaymentRequestDto;
import com.elroi.paymentservice.dto.PaymentResponseDto;
import com.elroi.paymentservice.model.Payment;
import com.elroi.paymentservice.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Payment APIs", description = "Controller for managing payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/api/test")
    @Operation(summary = "Test endpoint", description = "Returns a test message to verify the service is running.")
    public String test() {
        return "Payment service is running successfully.";
    }

    @GetMapping("/api/payments/all")
    @Operation(summary = "Get all payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok().body(paymentService.getAllPayments());
    }

    @PostMapping("/api/payments")
    @Operation(summary = "Create a new payment")
    public ResponseEntity<PaymentResponseDto> createPayment(@Valid @RequestBody PaymentRequestDto requestDto) {
        PaymentResponseDto responseDto = paymentService.createPayment(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/api/payments/{reference}")
    @Operation(summary = "Get payment by reference")
    public ResponseEntity<PaymentResponseDto> getPaymentByReference(@PathVariable String reference) {
        return ResponseEntity.ok().body(paymentService.getPaymentByReference(reference));
    }

    @DeleteMapping("/api/payments/{reference}")
    @Operation(summary = "Delete payment by reference")
    public String deletePaymentByReference(@PathVariable String reference) {
        return ResponseEntity.ok().body(paymentService.deletePaymentByReference(reference)).getBody();
    }

    @PutMapping("/api/payments/{reference}")
    @Operation(summary = "Update payment by reference")
    public ResponseEntity<PaymentResponseDto> updatePayment(@PathVariable String reference,
                                                          @Valid @RequestBody PaymentRequestDto requestDto) {
        PaymentResponseDto responseDto = paymentService.updatePayment(reference, requestDto);
        return ResponseEntity.ok().body(responseDto);
    }
}
