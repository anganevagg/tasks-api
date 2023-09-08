package com.anganevagg.tasks.tasksapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hello world";
    }
}
