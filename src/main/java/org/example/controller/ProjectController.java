package org.example.controller;


import org.example.entity.ProjectsList;
import org.example.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")

public class ProjectController {


    private ProjectService projectsService;

    public ProjectController(ProjectService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping("/employee/{empId}")
    public List<ProjectsList> getEmployeeProjects(@PathVariable Long empId) {
        return projectsService.getProjectsByEmpId(empId);
    }
}

