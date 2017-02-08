package com.pilarski.mmap.service;

import java.util.List;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;

public interface PlaceService {

	Place findPlace(long id);

	List<Place> findAll();
	List<Place> findPlaceByPlaceCategory(PlaceCategory placeCategory);

}
