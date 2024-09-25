package com.usermanagement.repository;

import com.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByMobNum(String mobNum);

    List<User> findByManagerId(UUID managerId);

    Optional<User> findByUserId(UUID userId);

    Optional<User> findByUserIdAndIsActive(UUID userId, boolean isActive);

    void deleteByUserId(UUID userId);

    void deleteByMobNum(String mobNum);
}
