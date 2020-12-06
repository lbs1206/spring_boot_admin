package com.fastcampus.study.repository;


import com.fastcampus.study.StudyApplicationTests;

import com.fastcampus.study.model.entity.User;
import org.junit.Assert;
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
        User user = new User();

        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUSer : " + newUser);
    }

    @Test
    public void read(){
        List<User> userList = userRepository.findAll();

        Optional<User> user = userRepository.findById(2L);//아이디 타입이 2번째가 있으면

        user.ifPresent(selectUser -> {//ID 값이 있으면
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });


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
