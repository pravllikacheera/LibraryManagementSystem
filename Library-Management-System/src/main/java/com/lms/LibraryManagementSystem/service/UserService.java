package com.lms.LibraryManagementSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.LibraryManagementSystem.model.Users;
import com.lms.LibraryManagementSystem.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo up;

	public Users createUser(Users u) {
		return up.save(u);
	}

	public Optional<Users> fetchUser(long id) {
		return up.findById(id);
	}

}
