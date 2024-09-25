package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
