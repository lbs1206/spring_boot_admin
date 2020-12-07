package com.fastcampus.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long partnerId;
}

// 1 : N
// LAZY = 지연로딩  , EAGER = 즉시로딩

// LAZY = SELECT * FROM item where id = ?

// EAGER = 1:1
// 연관관계 즉시 전부 연결
// item_id = order_detail.item_id
// user_id = order_detail.user_id
// where item.id = ?
// JOIN item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id

//@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//private List<OrderDetail> orderDetailList;
