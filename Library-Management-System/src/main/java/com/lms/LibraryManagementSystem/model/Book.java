package com.lms.LibraryManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	private long id;
	private String title;
	private String author;
	private boolean barrowed;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBarrowed() {
		return barrowed;
	}

	public void setBarrowed(boolean barrowed) {
		this.barrowed = barrowed;
	}

}
