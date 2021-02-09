package io.github.seclay2.webhookservice.model.hnp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {

    @JsonProperty("ProjectId")
    private int projectId;
    @JsonProperty("StageId")
    private int stageId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Icon")
    private String icon;
    @JsonProperty("Color")
    private String color;
    @JsonProperty("Status")
    private String status;

    public Stage() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "projectId=" + projectId +
                ", stageId=" + stageId +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", color='" + color + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
