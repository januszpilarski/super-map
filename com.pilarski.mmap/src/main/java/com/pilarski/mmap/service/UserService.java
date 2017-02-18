package com.pilarski.mmap.service;

import com.pilarski.mmap.domain.User;

public interface UserService {
	void save(User user);

    User findByUsername(String username);
}
