package com.anganevagg.tasks.tasksapi.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {
    @GetMapping("/api/tasks")
    public String getAll(){
        return "Get all routes";
    }

    @GetMapping("/api/tasks/{id}")
    public String getById(){
        return "Get by id";
    }

    @PostMapping("/api/tasks")
    public String create(){
        return "Create";
    }

    @PatchMapping("/api/tasks/{id}")
    public String update(){
        return "Update";
    }

    @DeleteMapping("/api/tasks/{id}")
    public String delete(){
        return "Delete";
    }
}
