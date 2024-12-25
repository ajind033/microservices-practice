package com.jindal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jindal.user.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

//	if you want any custom qry write here
}
