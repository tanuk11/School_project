package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.PrincipalRepository;
import com.school.Assignment;
import com.school.Principal;
import com.school.Teacher;

@Service
public class PrincipalService {
    @Autowired
    private PrincipalRepository principalRepository;
    
    public List<Principal> getAllPrincipals() {
        return principalRepository.findAll();
    }
    
    public Principal getPrincipalById(Long id) {
        return principalRepository.findById(id).orElse(null);
    }
    
    public Principal createPrincipal(Principal principal) {
        return principalRepository.save(principal);
    }
    
    public Principal updatePrincipal(Principal principal) {
        return principalRepository.save(principal);
    }
    
    public void deletePrincipal(Long id) {
        principalRepository.deleteById(id);
    }

	public List<Assignment> getAssignmentsByPrincipal(Principal principalEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Teacher> getTeachersByPrincipal(Principal principalEntity) {
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
