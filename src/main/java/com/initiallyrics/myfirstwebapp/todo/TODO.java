package com.initiallyrics.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class TODO {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	@Size(min=8, message= "Description should be atleast of 8 characters long!")
	private String description;
	private LocalDate expectedDate;
	private Boolean isDone;

	public TODO() {
	}
	
	public TODO(int id, String username, String description, LocalDate expectedDate, Boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.expectedDate = expectedDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	@Override
	public String toString() {
		return "TODO [id=" + id + ", username=" + username + ", description=" + description + ", expectedDate="
				+ expectedDate + ", isDone=" + isDone + "]";
	}

}
