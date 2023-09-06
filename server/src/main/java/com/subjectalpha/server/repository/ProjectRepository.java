package com.subjectalpha.server.repository;

import com.subjectalpha.server.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, String> {
}
