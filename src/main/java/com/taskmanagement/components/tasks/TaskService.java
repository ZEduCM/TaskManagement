/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanagement.components.tasks;

import com.taskmanagement.components.notification.INotificationService;
import com.taskmanagement.components.users.IUserService;
import com.taskmanagement.core.repositories.ITaskRepository;
import com.taskmanagement.core.domain.Task;
import com.taskmanagement.core.domain.User;
import com.taskmanagement.core.domain.TaskStatus;
import java.util.UUID;

/**
 *
 * @author educm
 */

/**
 * Composição e Integração.
 * Esta classe implementa a lógica de negócio de tarefas e COORDENA
 * outros componentes (User e Notification) através de suas interfaces.
 *
 * Princípio da Inversão de Dependência (SOLID - D) em ação.
 */
public class TaskService implements ITaskService {
    private final ITaskRepository taskRepository;
    private final IUserService userService;
    private final INotificationService notificationService;

    // As dependências são injetadas (Injeção de Dependência)
    public TaskService(ITaskRepository taskRepository, 
                           IUserService userService, 
                           INotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public Task createTask(String title, String description, UUID assigneeId) {
        // 1. USA O COMPONENTE DE USUÁRIO
        User assignee = userService.getUserById(assigneeId);
        if (assignee == null) {
            throw new RuntimeException("Usuário não encontrado!");
        }

        // 2. LÓGICA DE NEGÓCIO PRÓPRIA (SRP)
        Task task = new Task(UUID.randomUUID(), title, assigneeId, TaskStatus.TO_DO); // (Criaria com construtor)
        Task savedTask = taskRepository.save(task);

        // 3. USA O COMPONENTE DE NOTIFICAÇÃO
        String message = "Você foi atribuído à tarefa: " + title;
        notificationService.sendNotification(assignee, message);

        return savedTask;
    }

    public Task getTask(UUID taskId) {
        return taskRepository.findById(taskId);
    }
}
