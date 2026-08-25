package com.elroi.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private Long id;
    private Long patientId;
    private BigDecimal amount;
    private String status;
    private String paymentMethod;
    private String transactionReference;
    private String description;

}
