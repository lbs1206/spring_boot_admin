package com.fastcampus.study.repository;

import com.fastcampus.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {//<Model명, Id값 타입>
}
