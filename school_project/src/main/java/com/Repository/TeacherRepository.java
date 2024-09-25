package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}