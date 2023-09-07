package com.subjectalpha.server.dto;

import com.subjectalpha.server.model.ProjectModel;
import jakarta.validation.constraints.NotBlank;

public record ProjectDTO(@NotBlank(message = "Title can't be null or blank.") String title, String description, String active) {

    public ProjectDTO(ProjectModel projectModel) {
        this(
                projectModel.getTitle(),
                projectModel.getDescription(),
                projectModel.getActive()
        );
    }
}
