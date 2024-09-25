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
import com.service.PrincipalService;

@RestController
@RequestMapping("/principal")
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;
    
    @GetMapping("/assignments")
    public List<Assignment> getAssignmentsByPrincipal(@RequestHeader("X-Principal") Principal principal) {
        Principal principalEntity = principalService.getPrincipalById(principal.getUser().getId());
        return principalService.getAssignmentsByPrincipal(principalEntity);
    }
    
    @GetMapping("/teachers")
    public List<Teacher> getTeachersByPrincipal(@RequestHeader("X-Principal") Principal principal) {
        Principal principalEntity = principalService.getPrincipalById(principal.getUser().getId());
        return principalService.getTeachersByPrincipal(principalEntity);
    }
    
    @PostMapping("/assignments/{id}/grade")
    public Assignment gradeAssignment(@RequestHeader("X-Principal") Principal principal, @PathVariable Long id, @RequestBody String grade) {
        Principal principalEntity = principalService.getPrincipalById(principal.getUser().getId());
        Assignment assignment = principalService.getAssignmentById(id);
        assignment.setGrade(grade);
        assignment.setState("GRADED");
        return principalService.updateAssignment(assignment);
    }
}