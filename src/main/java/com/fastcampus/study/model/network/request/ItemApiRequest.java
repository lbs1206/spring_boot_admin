package com.fastcampus.study.model.network.request;

import com.fastcampus.study.model.enumClass.ItemStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ItemApiRequest {

    private Long id;

    private ItemStatus status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    @JsonProperty("brand_name")
    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @JsonProperty("partner_id")
    private Long partnerId;
}
