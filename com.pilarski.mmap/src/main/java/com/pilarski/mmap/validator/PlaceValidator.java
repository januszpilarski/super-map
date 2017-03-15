package com.pilarski.mmap.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;
import com.pilarski.mmap.service.PlaceService;

@Component
public class PlaceValidator implements Validator {
	@Autowired
	private PlaceService placeService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Place.class.equals(aClass);
	}
	
	PlaceCategory placeCategory;

	@Override
	public void validate(Object o, Errors errors) {
		Place place = (Place) o;

		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty");
		if (place.getName().length() < 2 || place.getName().length() > 100) {
			errors.rejectValue("name", "Size.placeForm.name");
		}
		if (placeService.findByName(place.getName()) != null) {
			errors.rejectValue("name", "Duplicate.placeForm.name");
		}

		ValidationUtils.rejectIfEmpty(errors, "coordinateX", "NotEmpty");
		if (place.getCoordinateX().matches("[0-8][0-9]-[0-5][0-9]-[0-5][0-9][NS]")) {
			errors.rejectValue("coordinateX", "Matches.placeForm.coordinateX");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "coordinateY", "NotEmpty");
		if (place.getCoordinateX().matches("[0-1][0-7][0-9]-[0-5][0-9]-[0-5][0-9][EW]")) {
			errors.rejectValue("coordinateY", "Matches.placeForm.coordinateY");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "placeCategory", "NotEmpty");
		if (place.getPlaceCategory().equals(placeCategory)) {
			errors.rejectValue("placeCategoryn", "Matches.placeForm.placeCategory");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "description", "NotEmpty");
		if (place.getDescription().length() < 2 || place.getDescription().length() > 1000) {
			errors.rejectValue("description", "Size.placeForm.description");
		}
		
	}
}
		

	
