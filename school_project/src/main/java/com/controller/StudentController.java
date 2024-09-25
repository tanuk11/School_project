package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.Assignment;
import com.school.Principal;
import com.school.Student;
import com.school.Teacher;
import com.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/assignments")
    public List<Assignment> getAssignmentsByStudent(@RequestHeader("X-Principal") Principal principal) {
        Student student = studentService.getStudentById(principal.getUser().getId());
        return studentService.getAssignmentsByStudent(student);
    }
    
    @PostMapping("/assignments")
    public Assignment createAssignment(@RequestHeader("X-Principal") Principal principal, @RequestBody Assignment assignment) {
        Student student = studentService.getStudentById(principal.getUser().getId());
        assignment.setStudent(student);
        return studentService.createAssignment(assignment);
    }
    
    @PostMapping("/assignments/{id}")
    public Assignment updateAssignment(@RequestHeader("X-Principal") Principal principal, @PathVariable Long id, @RequestBody Assignment assignment) {
        Student student = studentService.getStudentById(principal.getUser().getId());
        Assignment existingAssignment = studentService.getAssignmentById(id);
        existingAssignment.setContent(assignment.getContent());
        return studentService.updateAssignment(existingAssignment);
    }
    
    @PostMapping("/assignments/{id}/submit")
    public Assignment submitAssignment(@RequestHeader("X-Principal") Principal principal, @PathVariable Long id, @RequestBody Teacher teacher) {
        Student student = studentService.getStudentById(principal.getUser().getId());
        Assignment assignment = studentService.getAssignmentById(id);
        assignment.setTeacher(teacher);
        assignment.setState("SUBMITTED");
        return studentService.updateAssignment(assignment);
    }
}