package com.usermanagement.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String fullName;
    private String mobNum;
    private String panNum;
    private UUID managerId;
    private boolean isActive;
    private String createdAt;
    private String updatedAt;

}
