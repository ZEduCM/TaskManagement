/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanagement.components.notification;

import com.taskmanagement.core.domain.User;

/**
 *
 * @author educm
 */
public class EmailNotificationService implements INotificationService {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Email enviado para " + user.getEmail() + ": '" + message + "'");
    }
}
