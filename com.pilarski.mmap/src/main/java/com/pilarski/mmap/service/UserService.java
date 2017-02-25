package com.pilarski.mmap.service;

import com.pilarski.mmap.domain.User;

public interface UserService {
	void save(User user);

	User findUser(long id);

	User findByUsername(String username);

	User findByEmailAndActiveTrue(String username);
}
