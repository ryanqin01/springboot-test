package cn.ryan.springboot.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ryan.springboot.ServerConfig;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ServerConfig config;

	@Autowired
	private Environment env;

	@GetMapping
	public String sayHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("hello.message", null, locale) + " testvalue: " + config.getTestvalue() + ". environment: "
						+ env.getProperty("local.server.port") + ".";
	}
}
