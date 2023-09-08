package com.anganevagg.tasks.tasksapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anganevagg.tasks.tasksapi.models.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, UUID>{
    
}
