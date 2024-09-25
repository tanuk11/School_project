package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.StudentRepository;
import com.Repository.UserRepository;
import com.school.Assignment;
import com.school.Student;
import com.school.User;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

	public List<Assignment> getAssignmentsByStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public Assignment createAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		return null;
	}

	public Assignment updateAssignment(Assignment existingAssignment) {
		// TODO Auto-generated method stub
		return null;
	}

	public Assignment getAssignmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}