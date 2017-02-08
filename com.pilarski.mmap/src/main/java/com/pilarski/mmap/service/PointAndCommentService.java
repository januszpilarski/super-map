package com.pilarski.mmap.service;

import java.util.List;

import com.pilarski.mmap.domain.PointAndComment;

public interface PointAndCommentService {
	PointAndComment findById(Long id);
	List<PointAndComment> findAll();

}
