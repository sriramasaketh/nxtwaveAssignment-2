package com.usermanagement.repository;

import com.usermanagement.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, UUID> {

    Optional<Manager> findByManagerIdAndIsActive(UUID managerId, boolean isActive);

}
