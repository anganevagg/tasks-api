package com.anganevagg.tasks.tasksapi.dtos;

import com.anganevagg.tasks.tasksapi.models.TaskStatus;

public class UpdateTaskDto {
    private String      description;
    public void setDescription(String description) {
        this.description = description;
    }
    private TaskStatus  status;
    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public String getDescription(){
        return this.description;
    }
}
