package com.pilarski.mmap.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;
import com.pilarski.mmap.repository.PlaceRepository;

/**
 * 
 * @see PlaceService
 *
 */

@Service("PlaceService")
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Override
	public List<Place> findPlaceByPlaceCategory(PlaceCategory placeCategory) {
		return placeRepository.findPlaceByPlaceCategory(placeCategory);
	}
	
	@Override
    public void save(Place place){
        placeRepository.save(place);
    }

	@Override
	public Place findPlace(long id) {
		return placeRepository.findById(id);
	}
	
	@Override
	public Place findByName(String name){
		return placeRepository.findByName(name);
	}



	@Override
	public List<Place> findAll() {
		return placeRepository.findAll();
	}
	
	

}
