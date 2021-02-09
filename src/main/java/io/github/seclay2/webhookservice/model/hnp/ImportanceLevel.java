package io.github.seclay2.webhookservice.model.hnp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportanceLevel {

    @JsonProperty("ProjectId")
    private int projectId;
    @JsonProperty("ImportanceLevelId")
    private int importanceLevelId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Color")
    private String color;

    public ImportanceLevel() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getImportanceLevelId() {
        return importanceLevelId;
    }

    public void setImportanceLevelId(int importanceLevelId) {
        this.importanceLevelId = importanceLevelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ImportanceLevel{" +
                "projectId=" + projectId +
                ", importanceLevelId=" + importanceLevelId +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
