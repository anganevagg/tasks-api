package com.anganevagg.tasks.tasksapi.models;

import java.util.UUID;

import com.anganevagg.tasks.tasksapi.dtos.UpdateTaskDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public UUID getId() {
        return id;
    }
    @Column(name = "description")
    private String description;
    
    public String getDescription() {
        return description;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 15)
    private TaskStatus status;

    public TaskStatus getStatus() {
        return status;
    }
    public Tasks(String description, TaskStatus status){
        this.description    = description;
        this.status         = status;
    }
    public Tasks(){
        
    }
    public void update(UpdateTaskDto task){
        if(task.getStatus() != null){
            this.status = task.getStatus();
        }
        if(task.getDescription() != null){
            this.description = task.getDescription();
        }
    }
}
