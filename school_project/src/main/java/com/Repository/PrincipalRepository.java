package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {
}