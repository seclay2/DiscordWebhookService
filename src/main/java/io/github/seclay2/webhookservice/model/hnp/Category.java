package io.github.seclay2.webhookservice.model.hnp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    @JsonProperty("ProjectId")
    private int projectId;
    @JsonProperty("CategoryId")
    private int categoryId;
    @JsonProperty("Name")
    private String name;

    public Category() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "projectId=" + projectId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
