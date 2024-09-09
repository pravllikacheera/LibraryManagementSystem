package com.lms.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.LibraryManagementSystem.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{

}
