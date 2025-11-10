/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanagement.infra.db;

import com.taskmanagement.core.domain.Task;
import com.taskmanagement.core.repositories.ITaskRepository;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author educm
 */

/**
 * Implementação EM MEMÓRIA do repositório de tarefas.
 * Simula um banco de dados.
 */
public class InMemoryTaskRepository implements ITaskRepository {
    // Simula a tabela de Tarefas
    private final Map<UUID, Task> taskDatabase = new ConcurrentHashMap<>();
    

    /**
     * Implementação do método da interface.
     */
    public Task save(Task task) {
        // Salva (ou atualiza) a tarefa no "banco"
        taskDatabase.put(task.getId(), task);
        System.out.println("DEBUG (Repo): Tarefa " + task.getId() + " salva no repositório em memória.");
        return task;
    }

    /**
     * Implementação do método da interface.
     */
    public Task findById(UUID id) {
        return taskDatabase.get(id);
    }
}
