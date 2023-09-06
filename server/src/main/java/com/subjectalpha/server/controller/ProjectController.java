package com.subjectalpha.server.controller;

import com.subjectalpha.server.dto.ProjectDTO;
import com.subjectalpha.server.model.ProjectModel;
import com.subjectalpha.server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<Object> getAllProjects() {
        List<ProjectModel> projects = projectService.getAllProjects();

        if (projects.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("None projects were found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProjectById(@PathVariable String id) {
        Optional<ProjectModel> projectModel = projectService.getProjectById(id);

        if (projectModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(projectModel.get());
    }

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectModel projectModel = projectService.createProject(projectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable String id) {
        Boolean projectModel = projectService.updateProject(projectDTO, id);

        if (!projectModel) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Alterations successfully made!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable String id) {
        Optional<ProjectModel> projectModel = projectService.getProjectById(id);

        if (projectModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found.");
        }

        projectService.deleteProject(id);
        return ResponseEntity.status(HttpStatus.OK).body("Project successfully deleted!");
    }
}
