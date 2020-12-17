package com.fastcampus.study.repository;


import com.fastcampus.study.StudyApplicationTests;

import com.fastcampus.study.model.entity.Item;
import com.fastcampus.study.model.entity.User;
import com.fastcampus.study.model.enumClass.UserStatus;
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
        String account = "Test03";
        String password = "Test03";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
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
        //user.setCreatedAt(createdAt); // LoginUserAuditorAware 적용으로 자동 createdAt, createdBy 설정
        //user.setCreatedBy(createdBy);

        User u = User.builder()
                    .account(account)
                    .password(password)
                    .status(status)
                    .email(email)
                    .build();


        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
        Assertions.assertEquals("AdminServer", newUser.getCreatedBy());


    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        //user.setEmail("").setPhoneNumber("").setStatus("");//chain패턴
        //User u =  new User().setStatus("");//chain 패턴

        if(user != null){
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("------------주문묶음-------------");
                System.out.println(orderGroup.getRevName());
                System.out.println(orderGroup.getRevAddress());
                System.out.println(orderGroup.getTotalPrice());
                System.out.println(orderGroup.getTotalQuantity());


                System.out.println("------------주문상세-------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문의 상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());


                });

            });

        }


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
