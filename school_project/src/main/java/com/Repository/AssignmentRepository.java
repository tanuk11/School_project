package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.Assignment;
import com.school.Principal;
import com.school.Student;
import com.school.Teacher;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

	List<Assignment> findByStudent(Student student);

	List<Assignment> findByTeacher(Teacher teacher);

	List<Assignment> findByPrincipal(Principal principal);
}
