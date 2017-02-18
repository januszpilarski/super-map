package com.pilarski.mmap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pilarski.mmap.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findAll();

}
