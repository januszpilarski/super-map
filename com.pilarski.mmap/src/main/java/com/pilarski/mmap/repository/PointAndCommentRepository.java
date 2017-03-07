package com.pilarski.mmap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pilarski.mmap.domain.PointAndComment;

/**
 * 
 * Repository for working with {@link PointAndComment} domain object.
 *
 */
public interface PointAndCommentRepository extends CrudRepository<PointAndComment, Long> {
	
	PointAndComment findById(Long id);
	
	List<PointAndComment> findAll();
	
}
