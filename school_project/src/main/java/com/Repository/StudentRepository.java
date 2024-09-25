package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}