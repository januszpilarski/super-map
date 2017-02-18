package com.pilarski.mmap.form;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.pilarski.mmap.domain.PlaceCategory;


public class PlaceDTO {
	
	@NotBlank
	private String name;
	
	@NotEmpty
	private LocalDate localDateAdd;

	@NotBlank
	@Pattern(regexp="[0-8][0-9]-[0-5][0-9]-[0-5][0-9][NS]")
	private String coordinateX;
	
	@NotBlank
	@Pattern(regexp="[0-1][0-7][0-9]-[0-5][0-9]-[0-5][0-9][EW]")
	private String coordinateY;
	
	private String description;
	
	@Valid
	private PlaceCategory placeBranch;
	
	public PlaceCategory getPlaceBranch() {
		return placeBranch;
	}

	public void setPlaceBranch(PlaceCategory placeBranch) {
		this.placeBranch = placeBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinatex() {
		return coordinateX;
	}

	public void setCoordinatex(String coordinatex) {
		this.coordinateX = coordinatex;
	}

	public String getCoordinatey() {
		return coordinateY;
	}

	public void setCoordinatey(String coordinatey) {
		this.coordinateY = coordinatey;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getLocalDate() {
		return localDateAdd;
	}

	public void setLocalDate(LocalDate localDateAdd) {
		this.localDateAdd = localDateAdd;
	}

}
