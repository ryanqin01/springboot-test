package cn.ryan.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ryan.springboot.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDaoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private ObjectMapper mapper;

	private String[] users = { "{ \"name\" : \"ryan\", \"from\" : \"Jiangsu\" }", "{ \"name\" : \"yan\", \"from\" : \"Jiangsu\" }",
			"{ \"name\" : \"lynx\", \"from\" : \"Shanghai\" }", "{ \"name\" : \"tao\", \"from\" : \"Anhui\" }" };

	@Override
	public void run(String... args) throws Exception {
		for (String userString : users) {
			User user = mapper.readValue(userString, User.class);
			userDao.insert(user);
			log.info("Created new user: " + user.toString());
		}
	}
}
