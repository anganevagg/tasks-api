package com.anganevagg.tasks.tasksapi.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anganevagg.tasks.tasksapi.dtos.CreateTaskDto;
import com.anganevagg.tasks.tasksapi.dtos.UpdateTaskDto;
import com.anganevagg.tasks.tasksapi.models.Tasks;
import com.anganevagg.tasks.tasksapi.services.TasksServices;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    TasksServices service;
    
    @GetMapping()
    public ResponseEntity<List<Tasks>> getAll(){
        List<Tasks> tasks = service.getAllTasks();
        return new ResponseEntity<>(tasks, null, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getById(@PathVariable UUID id){
        Optional<Tasks> task= service.getTaskById(id);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Tasks> create(@RequestBody CreateTaskDto task){
        Tasks createdTask = service.createTask(task); 
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tasks> update(@PathVariable UUID id, @RequestBody UpdateTaskDto task){
        Optional<Tasks> updatedTask = service.updateTask(id, task);
        if(updatedTask.isPresent()){
            return ResponseEntity.ok(updatedTask.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id){
        service.deleteTask(id);
        return "Deleted";
    }
}
