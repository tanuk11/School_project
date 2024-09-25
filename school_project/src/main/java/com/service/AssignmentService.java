package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.AssignmentRepository;
import com.school.Assignment;
import com.school.Principal;
import com.school.Student;
import com.school.Teacher;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
    
    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }
    
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
    
    public Assignment updateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
    
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
    
    public List<Assignment> getAssignmentsByStudent(Student student) {
        return assignmentRepository.findByStudent(student);
    }
    
    public List<Assignment> getAssignmentsByTeacher(Teacher teacher) {
        return assignmentRepository.findByTeacher(teacher);
    }
    
    public List<Assignment> getAssignmentsByPrincipal(Principal principal) {
        return assignmentRepository.findByPrincipal(principal);
    }
}