package com.pilarski.mmap.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.User;
import com.pilarski.mmap.service.CurrentUserServiceImpl;
import com.pilarski.mmap.service.CurrentUserServiceImpl;
import com.pilarski.mmap.service.PlaceService;
import com.pilarski.mmap.service.SecurityService;
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
	private CurrentUserServiceImpl curUserSer;

	@RequestMapping(value = "/addPlace", method = RequestMethod.GET)
	public String addPlace(Model model) {
		model.addAttribute("placeForm", new Place());

		return "addPlace";
	}

	@RequestMapping(value = "/addPlace", method = RequestMethod.POST)
	public String addPlace(@ModelAttribute("placeForm") Place placeForm, BindingResult bindingResult, Model model) {
		placeValidator.validate(placeForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "addPlace";
		}
		
	
		String user = curUserSer.getLogin();
		System.out.println(user);
		placeForm.setLocalDateAdd(LocalDate.now());
		placeForm.setUser(userService.findByUsername(user));;
		placeService.save(placeForm);
		
		return "redirect:/addPlace";
	}

}