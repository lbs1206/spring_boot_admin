package com.fastcampus.study.repository;


import com.fastcampus.study.StudyApplicationTests;

import com.fastcampus.study.model.entity.Item;
import com.fastcampus.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class UserRepositoryTest extends StudyApplicationTests {

    //Dependency Injectyion(DI)
    //UserRepository userRepository = new UserRepository();를 아래에서 사용할떄 자동적으로 찾아서 해줌
    @Autowired//직접 객체 생성
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer"; // LoginUserAuditorAware 적용으로 자동 createdBy 설정


        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt); // LoginUserAuditorAware 적용으로 자동 createdAt, createdBy 설정
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
        Assertions.assertEquals("AdminServer", newUser.getCreatedBy());


    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assertions.assertNotNull(user);

    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("ppppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);//아이디 값 없으면 insert, 있으면 update
        });
    }

    @Test
    @Transactional//테스트후 데이터 롤백
    public void delete(){
        Optional<User> user = userRepository.findById(4L);

        Assert.assertTrue(user.isPresent()); //true

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);//아이디 값 없으면 insert, 있으면 update
        });

        Optional<User> deleteUser = userRepository.findById(4L);

        Assert.assertFalse(deleteUser.isPresent()); //false
    }
}
