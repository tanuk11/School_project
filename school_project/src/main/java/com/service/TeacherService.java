package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.TeacherRepository;
import com.school.Assignment;
import com.school.Teacher;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }
    
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

	public List<Assignment> getAssignmentsByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	public Assignment getAssignmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Assignment updateAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		return null;
	}
}
