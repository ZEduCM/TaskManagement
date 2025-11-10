/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.taskmanagement.components.notification;

import com.taskmanagement.core.domain.User;

/**
 *
 * @author educm
 */
public interface INotificationService {
    void sendNotification(User user, String message);
}
