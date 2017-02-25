package com.pilarski.mmap.repository;

import org.springframework.data.repository.CrudRepository;

import com.pilarski.mmap.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findById(Long id);
	User findByUsername(String username);
	User findByEmail(String email);

}
