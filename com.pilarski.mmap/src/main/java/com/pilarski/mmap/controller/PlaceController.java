package com.pilarski.mmap.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.service.CurrentUserService;
import com.pilarski.mmap.service.PlaceService;
import com.pilarski.mmap.service.UserService;
import com.pilarski.mmap.validator.PlaceValidator;

@Controller
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	@Autowired
	private PlaceValidator placeValidator;
	@Autowired
	private UserService userService;
	@Autowired
	private CurrentUserService curUserSer;
	/**
	 * This method display form to add new place to database.
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/addPlace", method = RequestMethod.GET)
	public String addPlace(Model model) {
		model.addAttribute("placeForm", new Place());

		return "addPlace";
	}
	/**
	 * This method save new place in database.
	 * @param placeForm Parameter passes place object to validation. 
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addPlace", method = RequestMethod.POST)
	public String addPlace(@ModelAttribute("placeForm") Place placeForm, BindingResult bindingResult, Model model) {
		placeValidator.validate(placeForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "addPlace";
		}		
	
		String user = curUserSer.getLogin();
		System.out.println(user);
		placeForm.setLocalDateAdd(LocalDate.now());
		placeForm.setUser(userService.findByUsername(user));
		placeService.save(placeForm);
		
		return "redirect:/addPlace";
	}
	/**
	 * This method display all places from database.
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/getPlaces", method = RequestMethod.GET)
	public String getPlaces(Model model) {
		List<Place> places = placeService.findAll();
		model.addAttribute("places", places);
		return "getPlaces";
	}
	/**
	 * This method display place details.
	 * @param id
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/placeDetails/{id}", method = RequestMethod.GET)
	public String placeDetails(@PathVariable("id") Long id, Model model) {
		Place place = placeService.findPlace(id);
		model.addAttribute("place", place);
		return "placeDetails";
	}

}