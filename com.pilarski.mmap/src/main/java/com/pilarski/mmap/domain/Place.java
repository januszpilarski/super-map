package com.pilarski.mmap.domain;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by januszpilarski.
 */

@Entity
public class Place {

	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", coordinateX=" + coordinateX + ", coordinateY=" + coordinateY
				+ ", description=" + description + ", localDateAdd=" + localDateAdd + ", placeCategory=" + placeCategory
				+ ", rate=" + rate + ", pointsAndComments=" + pointsAndComments + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "place_id")
	private Long id;
	private String name;
	private String coordinateX;
	private String coordinateY;
	private String description;
	private LocalDate localDateAdd;
	@Enumerated(EnumType.STRING)
	private PlaceCategory placeCategory;
	private int rate;
	@OneToMany(mappedBy = "place")
	private List<PointAndComment> pointsAndComments;

	public Place() {
	}

	public Place(String name, String coordinatex, String coordinatey, String description, LocalDate localDateAdd,
			PlaceCategory placeBranch) {
		this.name = name;
		this.coordinateX = coordinatex;
		this.coordinateY = coordinatey;
		this.description = description;
		this.localDateAdd = localDateAdd;
		this.placeCategory = placeBranch;
	}

	public List<PointAndComment> getPointsAndComments() {
		return pointsAndComments;
	}

	public void setPointAndComment(List<PointAndComment> pointsAndComments) {
		this.pointsAndComments = pointsAndComments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}

	public String getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getlocalDateAdd() {
		return localDateAdd;
	}

	public void setlocalDateAdd(LocalDate dateadd) {
		this.localDateAdd = dateadd;
	}

	public PlaceCategory getPlaceCategory() {
		return placeCategory;
	}

	public void setPlaceCategory(PlaceCategory placeCategory) {
		this.placeCategory = placeCategory;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
