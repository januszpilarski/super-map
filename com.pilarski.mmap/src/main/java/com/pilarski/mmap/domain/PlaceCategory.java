package com.pilarski.mmap.domain;


public enum PlaceCategory {

	ARCHITECTURE("architecture"), 
	PLANTS("plants"), 
	ROCKS("rocks"), 
	OTHER("other");
	
	private final String category;
	
	private PlaceCategory(String category){
		this.category = category;	
	}
	
	public String getCategory(){
		return category;
	}

}
