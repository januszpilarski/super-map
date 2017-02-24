package com.pilarski.mmap.service;

import java.util.List;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;

public interface PlaceService {

	Place findPlace(long id);

	Place findByName(String name);

	void save(Place place);

	List<Place> findAll();

	List<Place> findPlaceByPlaceCategory(PlaceCategory placeCategory);

}
