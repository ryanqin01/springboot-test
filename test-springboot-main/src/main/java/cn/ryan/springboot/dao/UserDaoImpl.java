package cn.ryan.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cn.ryan.springboot.model.User;

@Repository
@Transactional
public class UserDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();

	}
}
