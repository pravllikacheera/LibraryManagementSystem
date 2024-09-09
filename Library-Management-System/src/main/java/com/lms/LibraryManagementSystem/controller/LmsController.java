package com.lms.LibraryManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.LibraryManagementSystem.model.Book;
import com.lms.LibraryManagementSystem.model.Users;
import com.lms.LibraryManagementSystem.service.BookService;
import com.lms.LibraryManagementSystem.service.UserService;

@RestController
@RequestMapping("/api")
public class LmsController {

	@Autowired
	private UserService us;

	@Autowired
	private BookService bs;

	@PostMapping("/createuser")
	public Users createUser(@RequestBody Users u) {
		return us.createUser(u);
	}

	@GetMapping("/fetchuser/{id}")
	public Optional<Users> fetchUser(@PathVariable long id) {
		return us.fetchUser(id);
	}

	@PostMapping("/addnewbook")
	public Book addNewBook(@RequestBody Book b) {
		return bs.addNewBook(b);
	}

	@GetMapping("/fetchallbooks")
	public List<Book> fetchAllBooks() {
		return bs.fetchAllBooks();
	}

	@GetMapping("/fetchbook/{id}")
	public Optional<Book> fetchBook(@PathVariable long id) {
		return bs.fetchBook(id);
	}

	@DeleteMapping("/deletebook/{id}")
	public void deleteBook(@PathVariable long id) {
		bs.deleteBook(id);
	}

	@GetMapping("/{id}/barrowbook/{userId}")
	public Book barrowBook(@PathVariable long id, @RequestBody Book book, @PathVariable long userId) {
		return bs.barrowBook(id, userId);
	}

	@GetMapping("/{id}/return")
	public Book returnBook(@PathVariable long id, @RequestBody Book book) {
		return bs.returnBook(id);
	}

}
