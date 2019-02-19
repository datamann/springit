package com.sbs.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbs.springit.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
