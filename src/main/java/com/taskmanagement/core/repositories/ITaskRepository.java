/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.taskmanagement.core.repositories;

import com.taskmanagement.core.domain.Task;
import java.util.UUID;

/**
 *
 * @author educm
 */
public interface ITaskRepository {
    Task save(Task task);
    Task findById(UUID id);
}
