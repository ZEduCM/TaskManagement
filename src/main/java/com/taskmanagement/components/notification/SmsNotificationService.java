package com.taskmanagement.components.notification;

import com.taskmanagement.core.domain.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author educm
 */
public class SmsNotificationService implements INotificationService {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sms enviado para o número " + user.getPhone() + ": '" + message + "'");
    }
}
