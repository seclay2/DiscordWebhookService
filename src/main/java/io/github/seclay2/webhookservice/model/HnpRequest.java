package io.github.seclay2.webhookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HnpRequest {

    @JsonProperty("ProjectId")
    private int projectId;
    @JsonProperty("WorkItemId")
    private int workItemId;
    @JsonProperty("ParentStoryId")
    private int parentStoryId;
    @JsonProperty("IsStory")
    private boolean isStory;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Stage")
    private Stage stage;
    @JsonProperty("Board")
    private Board board;
    @JsonProperty("AssignedUsers")
    private AssignedUser[] assignedUsers;
    @JsonProperty("ImportanceLevel")
    private ImportanceLevel importanceLevel;

    public HnpRequest() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(int workItemId) {
        this.workItemId = workItemId;
    }

    public int getParentStoryId() {
        return parentStoryId;
    }

    public void setParentStoryId(int parentStoryId) {
        this.parentStoryId = parentStoryId;
    }

    public boolean isStory() {
        return isStory;
    }

    public void setStory(boolean story) {
        isStory = story;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public AssignedUser[] getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(AssignedUser[] assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public ImportanceLevel getImportanceLevel() {
        return importanceLevel;
    }

    public void setImportanceLevel(ImportanceLevel importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    @Override
    public String toString() {
        return "HnpRequest{" +
                "projectId=" + projectId +
                ", workItemId=" + workItemId +
                ", parentStoryId=" + parentStoryId +
                ", isStory=" + isStory +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", stage=" + stage +
                ", assignedUsers=" + Arrays.toString(assignedUsers) +
                ", importanceLevel=" + importanceLevel +
                '}';
    }
}
