package cn.ryan.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ryan.springboot.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
