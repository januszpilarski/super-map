package com.pilarski.mmap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;

import java.util.List;


@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {
	Place findById(Long id);
 	List<Place> findPlaceByPlaceCategory(PlaceCategory placeCategory);
	List<Place> findAll();
	Place findByName(String name);

}
