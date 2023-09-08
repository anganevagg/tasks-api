package com.anganevagg.tasks.tasksapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anganevagg.tasks.tasksapi.dtos.CreateTaskDto;
import com.anganevagg.tasks.tasksapi.dtos.UpdateTaskDto;
import com.anganevagg.tasks.tasksapi.models.TaskStatus;
import com.anganevagg.tasks.tasksapi.models.Tasks;
import com.anganevagg.tasks.tasksapi.repositories.TasksRepository;

@Service
public class TasksServices {
    @Autowired
    private TasksRepository tasksRepository;
    
    public List<Tasks> getAllTasks(){
        return tasksRepository.findAll();
    }
    public Optional<Tasks> getTaskById(UUID id){
        return tasksRepository.findById(id);
    }
    public Tasks createTask(CreateTaskDto task){
        Tasks newTask = new Tasks(task.getDescription(), TaskStatus.PENDING);
        return tasksRepository.save(newTask);
    }
    public Optional<Tasks> updateTask(UUID id, UpdateTaskDto task) {
        if(!tasksRepository.existsById(id)){
            Optional.empty();
        }
        Tasks foundTask     = tasksRepository.findById(id).orElseThrow();
        foundTask.update(task);
        Tasks updatedTask   = tasksRepository.save(foundTask);
        return Optional.of(updatedTask);
    }
    public void deleteTask(UUID id){
        tasksRepository.deleteById(id);
    }
}
