package com.Ty.user.userDetails.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Ty.user.userDetails.dto.User;
import com.Ty.user.userDetails.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
		

	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
