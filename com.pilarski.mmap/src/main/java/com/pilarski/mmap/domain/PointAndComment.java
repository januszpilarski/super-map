package com.pilarski.mmap.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PointAndComment {
	
	public PointAndComment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pointAndComment_id")
	private Long id;
	@Column(name="point", nullable = true)
	private boolean point;
	private String comment;
	@ManyToOne
	@JoinColumn(name="place_id")
	Place place;
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean getPoint() {
		return point;
	}

	public void setPoint(boolean point) {
		this.point = point;
	}
	

}
