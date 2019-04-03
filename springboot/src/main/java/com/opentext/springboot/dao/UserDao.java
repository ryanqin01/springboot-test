package com.opentext.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opentext.springboot.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
