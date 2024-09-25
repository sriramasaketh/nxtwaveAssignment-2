package com.usermanagement.dto;

import java.util.List;
import java.util.UUID;

public class UserRequest {

    private String fullName;
    private String mobNum;
    private String panNum;
    private UUID managerId;

    private List<UUID> userIds;
    private UpdateData updateData;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public String getPanNum() {
        return panNum;
    }

    public void setPanNum(String panNum) {
        this.panNum = panNum;
    }

    public UUID getManagerId() {
        return managerId;
    }

    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }

    public List<UUID> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<UUID> userIds) {
        this.userIds = userIds;
    }

    public UpdateData getUpdateData() {
        return updateData;
    }

    public void setUpdateData(UpdateData updateData) {
        this.updateData = updateData;
    }

    public static class UpdateData {
        private String fullName;
        private String mobNum;
        private String panNum;
        private UUID managerId;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getMobNum() {
            return mobNum;
        }

        public void setMobNum(String mobNum) {
            this.mobNum = mobNum;
        }

        public String getPanNum() {
            return panNum;
        }

        public void setPanNum(String panNum) {
            this.panNum = panNum;
        }

        public UUID getManagerId() {
            return managerId;
        }

        public void setManagerId(UUID managerId) {
            this.managerId = managerId;
        }
    }
}
