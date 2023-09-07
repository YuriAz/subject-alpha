package com.subjectalpha.server.model;

import com.subjectalpha.server.dto.ProjectDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "projects")
@Data
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 100)
    private String title;

    private String description;

    @Column(length = 1)
    private String active = "Y";

    public ProjectModel() {
    }

    public ProjectModel(ProjectDTO projectDTO) {
        this.title = projectDTO.title();
        this.description = projectDTO.description();
        this.active = validateActive(projectDTO.active());
    }

    private String validateActive(String active) {
        return active.isEmpty() || active.isBlank() ? "Y" : active;
    }
}
