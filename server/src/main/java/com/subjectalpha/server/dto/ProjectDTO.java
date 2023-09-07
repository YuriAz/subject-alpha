package com.subjectalpha.server.dto;

import jakarta.validation.constraints.NotBlank;

public record ProjectDTO(
        @NotBlank(message = "Title can't be null or blank.") String title,
        String description,
        String active
) {
    public ProjectDTO(@NotBlank(message = "Title can't be null or blank.") String title, String description) {
        this(title, description, "Y");
    }
}
