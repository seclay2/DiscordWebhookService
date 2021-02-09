package io.github.seclay2.webhookservice.model.hnp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignedUser {

    @JsonProperty("ProjectId")
    private int projectId;
    @JsonProperty("User")
    private User user;
    @JsonProperty("IsAdmin")
    private boolean isAdmin;

    public AssignedUser() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "AssignedUser{" +
                "projectId=" + projectId +
                ", user=" + user +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
