package com.usermanagement.service;

import com.usermanagement.dto.UserRequest;
import com.usermanagement.exception.CustomException;
import com.usermanagement.model.Manager;
import com.usermanagement.model.User;
import com.usermanagement.repository.ManagerRepository;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public String createUser(UserRequest request) {
        ValidationUtil.validateUserRequest(request);

        if (request.getManagerId() != null) {
            Manager manager = managerRepository.findById(request.getManagerId())
                    .orElseThrow(() -> new CustomException("Manager not found"));
            if (!manager.isActive()) {
                throw new CustomException("Manager is inactive");
            }
        }

        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setFullName(request.getFullName());
        user.setMobNum(ValidationUtil.formatMobileNumber(request.getMobNum()));
        user.setPanNum(request.getPanNum().toUpperCase());
        user.setManagerId(request.getManagerId());
        user.setActive(true);
        user.setCreatedAt(ValidationUtil.getCurrentTimestamp());

        userRepository.save(user);
        return "User created successfully";
    }

}
