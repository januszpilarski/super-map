package com.pilarski.mmap.web;

import com.pilarski.mmap.domain.Place;
import com.pilarski.mmap.domain.PlaceCategory;
import com.pilarski.mmap.domain.PointAndComment;
import com.pilarski.mmap.repository.PlaceRepository;
import com.pilarski.mmap.repository.PointAndCommentRepository;
import com.pilarski.mmap.service.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dingo on 20.01.2017.
 */
@RestController
@RequestMapping("/mmap")
public class PlaceRestController {
	
/*	to delete*/
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private PointAndCommentRepository pointAndCommentRepository;
	@Autowired
	private PlaceService placeService;



	@GetMapping("/findAll")
	List<Place> findAll() {
		return placeService.findAll();
	}

	@GetMapping("/{placeId}")
	Place findOne(@PathVariable("placeId") Long id) {
		return placeService.findPlace(id);
	}

	@GetMapping("/findByBranch{placeCategory}")
	List<Place> findByBranch(@RequestParam("placeCategory") PlaceCategory placeCategory) {
		return placeService.findPlaceByPlaceCategory(placeCategory);
	}

	@PostMapping("/addPlace")
	void addPlace(@RequestParam("name") String name, @RequestParam("X") String coordinateX,
			@RequestParam("Y") String coordinateY,
			@RequestParam(required = false, name = "description") String description,
			@RequestParam("branch") PlaceCategory placeBranch) {

		Place place = new Place(name, coordinateX, coordinateY, description, LocalDate.now(), placeBranch);
		placeRepository.save(place);
	}

	@PostMapping("/updatePlace{placeId}{description}")
	void updatePlace(@RequestParam("placeId") Long id, @RequestParam("description") String description) {
		Place place = placeRepository.findById(id);
		place.setDescription(description);
		placeRepository.save(place);
	}

	@PostMapping("/givePoint/{placeId}{point}")
	void givePoint(@PathVariable("placeId") Long id, @RequestParam("point") boolean point) {
		Place place = placeRepository.findById(id);
		PointAndComment pointAndComment = new PointAndComment();
		pointAndComment.setPoint(point);
		pointAndComment.setPlace(place);
		pointAndCommentRepository.save(pointAndComment);
		if (point) {
			place.setRate(place.getRate() + 1);
		}
		;
		placeRepository.save(place);
	}

	@PostMapping("/commentPlace/{placeId}{comment}")
	void commentPlace(@PathVariable("placeId") Long id, @RequestParam("comment") String comment) {
		Place place = placeRepository.findById(id);
		PointAndComment pointAndComment = new PointAndComment();
		pointAndComment.setComment(comment);
		pointAndComment.setPlace(place);
		pointAndCommentRepository.save(pointAndComment);
		placeRepository.save(place);

	}

	// @GetMapping("{companyName}/${urls.company.employees.root}/{lastName}/{firstName}")
	// List<Employee> findCompanyEmployeesWithLastNameAndFirstName(@PathVariable
	// Map<String, String> pathVariable) {
	// return findOne(pathVariable.get("companyName"))
	// .getEmployees()
	// .stream()
	// .filter(employee -> Objects.equals(employee.getLastName(),
	// pathVariable.get("lastName")))
	// .filter(employee -> Objects.equals(employee.getFirstName(),
	// pathVariable.get("firstName")))
	// .collect(Collectors.toList());
	// }

	// @RequestMapping("getPlaces")
	// public @ResponseBody List<Place> getPlaces(){
	// List<Place> result = new ArrayList<>();
	//
	// result.add(new Place("Waligóra", "1234", "4321", "góra", LocalDate.now(),
	// Branch.ROCKS));
	// result.add(new Place("Stożek Wielki", "4567", "5678", "góra",
	// LocalDate.now(), Branch.ROCKS));
	// result.add(new Place("Czrnek", "123445", "5678", "góra", LocalDate.now(),
	// Branch.ROCKS));
	//
	// return result;
	// }
}
