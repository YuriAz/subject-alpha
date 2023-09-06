package com.subjectalpha.server.dto;

import com.subjectalpha.server.model.ProjectModel;

public record ProjectDTO(String title, String description, String active) {

    public ProjectDTO(ProjectModel projectModel) {
        this(
                projectModel.getTitle(),
                projectModel.getDescription(),
                projectModel.getActive()
        );
    }
}
