package com.usermanagement.service;

import com.usermanagement.exception.ResourceNotFoundException;
import com.usermanagement.model.Manager;
import com.usermanagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager validateActiveManager(UUID managerId) {
        Optional<Manager> manager = managerRepository.findByManagerIdAndIsActive(managerId, true);

        if (manager.isEmpty()) {
            throw new ResourceNotFoundException("Manager with ID " + managerId + " not found or inactive.");
        }

        return manager.get();
    }

    public Manager getManagerById(UUID managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with ID " + managerId + " not found."));
    }

    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public void deactivateManager(UUID managerId) {
        Manager manager = getManagerById(managerId);
        manager.setIsActive(false);
        managerRepository.save(manager);
    }
}
