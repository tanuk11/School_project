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
import com.school.Teacher;
import com.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    
    @GetMapping("/assignments")
    public List<Assignment> getAssignmentsByTeacher(@RequestHeader("X-Principal") Principal principal) {
        Teacher teacher = teacherService.getTeacherById(principal.getUser().getId());
        return teacherService.getAssignmentsByTeacher(teacher);
    }
    
    @PostMapping("/assignments/{id}/grade")
    public Assignment gradeAssignment(@RequestHeader("X-Principal") Principal principal, @PathVariable Long id, @RequestBody String grade) {
        Teacher teacher = teacherService.getTeacherById(principal.getUser().getId());
        Assignment assignment = teacherService.getAssignmentById(id);
        assignment.setGrade(grade);
        assignment.setState("GRADED");
        return teacherService.updateAssignment(assignment);
    }
}