package com.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Manager {
    @Id
    private UUID managerId;

    private String fullName;
    private boolean isActive;

}
