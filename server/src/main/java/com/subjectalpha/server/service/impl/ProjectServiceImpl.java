package com.subjectalpha.server.service.impl;

import com.subjectalpha.server.dto.ProjectDTO;
import com.subjectalpha.server.model.ProjectModel;
import com.subjectalpha.server.repository.ProjectRepository;
import com.subjectalpha.server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<ProjectModel> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public ProjectModel createProject(ProjectDTO projectDTO) {
        ProjectModel projectModel = new ProjectModel();
        BeanUtils.copyProperties(projectDTO, projectModel);
        projectRepository.save(projectModel);
        return projectModel;
    }

    @Override
    public Boolean updateProject(ProjectDTO projectDTO, String id) {
        Optional<ProjectModel> projectModel = projectRepository.findById(id);

        if (projectModel.isEmpty()) {
            return false;
        }

        BeanUtils.copyProperties(projectDTO, projectModel.get());
        projectRepository.save(projectModel.get());
        return true;
    }

    @Override
    public Boolean deleteProject(String id) {
        Optional<ProjectModel> projectModel = projectRepository.findById(id);

        if (projectModel.isEmpty()) {
            return false;
        }

        projectRepository.delete(projectModel.get());
        return true;
    }
}
