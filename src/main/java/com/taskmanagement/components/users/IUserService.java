/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.taskmanagement.components.users;

import com.taskmanagement.core.domain.User;
import java.util.UUID;

/**
 *
 * @author educm
 */
public interface IUserService {
    User getUserById(UUID id);
}
