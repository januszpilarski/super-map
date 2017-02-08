package com.pilarski.mmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilarski.mmap.domain.PointAndComment;
import com.pilarski.mmap.repository.PointAndCommentRepository;

@Service("PointAndCommentService")
public class PointAndCommentServiceImpl implements PointAndCommentService {
	@Autowired
	private PointAndCommentRepository pointAndCommentRepository;

	@Override
	public PointAndComment findById(Long id) {
		return pointAndCommentRepository.findById(id);
	}

	@Override
	public List<PointAndComment> findAll() {
		return pointAndCommentRepository.findAll();
	}
	
	

}
