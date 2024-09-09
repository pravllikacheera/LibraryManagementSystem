package com.lms.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.LibraryManagementSystem.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

}
