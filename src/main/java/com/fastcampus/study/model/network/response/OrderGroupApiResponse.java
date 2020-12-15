package com.fastcampus.study.model.network.response;

import com.fastcampus.study.model.enumClass.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderGroupApiResponse {

    private Long id;

    private String status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private String paymentType; // 카드 // 현금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;
}
