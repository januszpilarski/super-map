package com.pilarski.mmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pilarski.mmap.domain.User;
import com.pilarski.mmap.service.SecurityService;
import com.pilarski.mmap.service.UserService;

@RestController
@RequestMapping("/mmap")
public class UserController {
	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration{name}{password}{email}")
	void registration(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("email") String email) {
		User user = new User(name, password, email);
		userService.save(user);
	}

}
