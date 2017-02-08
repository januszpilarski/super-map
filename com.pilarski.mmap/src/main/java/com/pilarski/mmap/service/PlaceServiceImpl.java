package com.pilarski.mmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;
import com.pilarski.mmap.repository.PlaceRepository;

@Service("PlaceService")
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	

	@Override
	public List<Place> findPlaceByPlaceCategory(PlaceCategory placeCategory) {
		return placeRepository.findPlaceByPlaceCategory(placeCategory);
	}



	@Override
	public Place findPlace(long id) {
		return placeRepository.findById(id);
	}



	@Override
	public List<Place> findAll() {
		return placeRepository.findAll();
	}
	
	

}
