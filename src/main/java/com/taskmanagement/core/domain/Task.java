/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanagement.core.domain;

import java.util.UUID;

/**
 *
 * @author educm
 */
public class Task {
    private UUID id;
    private String title;
    private UUID assigneeId;
    private TaskStatus status;

    public Task(UUID id, String title, UUID assigneeId, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.assigneeId = assigneeId;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(UUID assigneeId) {
        this.assigneeId = assigneeId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    
}
