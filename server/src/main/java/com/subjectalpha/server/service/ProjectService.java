package com.subjectalpha.server.service;

import com.subjectalpha.server.dto.ProjectDTO;
import com.subjectalpha.server.model.ProjectModel;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<ProjectModel> getAllProjects();

    Optional<ProjectModel> getProjectById(String id);

    ProjectModel createProject(ProjectDTO projectDTO);

    Boolean updateProject(ProjectDTO projectDTO, String id);

    Boolean deleteProject(String id);
}
