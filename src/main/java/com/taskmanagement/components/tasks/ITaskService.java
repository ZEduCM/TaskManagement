/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.taskmanagement.components.tasks;

import com.taskmanagement.core.domain.Task;
import java.util.UUID;
        
/**
 *
 * @author educm
 */
public interface ITaskService {
    Task createTask(String title, String description, UUID assigneeId);
    Task getTask(UUID taskId);
}
