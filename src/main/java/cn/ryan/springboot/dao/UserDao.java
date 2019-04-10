package cn.ryan.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ryan.springboot.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	List<User> findByFrom(String from);
}
