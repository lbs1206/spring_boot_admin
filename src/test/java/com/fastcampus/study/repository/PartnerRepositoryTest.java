package com.fastcampus.study.repository;

import com.fastcampus.study.StudyApplicationTests;
import com.fastcampus.study.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends StudyApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt); // LoginUserAuditorAware 적용으로 자동 createdAt, createdBy 설정
        partner.setCreatedBy(createdBy); // LoginUserAuditorAware 적용으로 자동 createdAt, createdBy 설정
        //partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);
        Assertions.assertNotNull(newPartner);
        Assertions.assertEquals(newPartner.getName(), name);
    }
}
