package com.pilarski.mmap.repository;

import org.springframework.data.repository.CrudRepository;

import com.pilarski.mmap.domain.User;

/**
 * 
 * Repository for working with {@link User} domain object.
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findById(Long id);
	
	User findByUsername(String username);
	
	User findByEmail(String email);

}
