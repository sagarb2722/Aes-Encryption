package com.Ty.user.userDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ty.user.userDetails.dto.User;


public interface UserRepository extends JpaRepository<User, Integer>  {

}
