package com.lms.LibraryManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.LibraryManagementSystem.model.Book;
import com.lms.LibraryManagementSystem.model.Users;
import com.lms.LibraryManagementSystem.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private UserService us;
	@Autowired
	private BookRepo bp;

	public Book addNewBook(Book b) {
		return bp.save(b);
	}

	public List<Book> fetchAllBooks() {
		return bp.findAll();
	}

	public Optional<Book> fetchBook(long id) {
		return bp.findById(id);
	}

	public void deleteBook(long id) {
		bp.deleteById(id);
	}

	public Book barrowBook(long id, long userId) {
		Book book = fetchBook(id).orElseThrow(() -> new RuntimeException("book not found"));
		Users user = us.fetchUser(userId).orElseThrow(() -> new RuntimeException("user not found"));
		book.setBarrowed(true);
		book.setUser(user);
		return bp.save(book);
	}

	public Book returnBook(long id) {
		Book book = fetchBook(id).orElseThrow(() -> new RuntimeException("book not found"));
		book.setBarrowed(false);
		book.setUser(null);
		return bp.save(book);
	}

}
