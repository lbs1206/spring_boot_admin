package com.fastcampus.study.repository;

import com.fastcampus.study.StudyApplicationTests;
import com.fastcampus.study.model.entity.Item;
import com.fastcampus.study.model.enumClass.ItemStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests{

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus(ItemStatus.UNREGISTERED);
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다");
        item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now()); // LoginUserAuditorAware 적용으로 자동 createdAt, createdBy 설정
        item.setCreatedBy("Partner01"); // LoginUserAuditorAware 적용으로 자동 createdAt, createdBy 설정
        //item.setPartnerId(1L);


        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }


    @Test
    public void read() {
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());
    }
}
