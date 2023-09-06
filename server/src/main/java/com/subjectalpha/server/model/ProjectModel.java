package com.subjectalpha.server.model;

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
}
