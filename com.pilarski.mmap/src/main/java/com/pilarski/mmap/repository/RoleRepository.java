package com.pilarski.mmap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pilarski.mmap.domain.Role;

/**
 * 
 * Repository for working with {@link Role} domain object.
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	List<Role> findAll();

}
