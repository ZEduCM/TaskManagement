/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.taskmanagement.app;

import com.taskmanagement.components.notification.EmailNotificationService;
import com.taskmanagement.components.notification.INotificationService;
import com.taskmanagement.components.notification.SmsNotificationService;
import com.taskmanagement.components.taskmanagement.ITaskService;
import com.taskmanagement.components.taskmanagement.TaskService;
import com.taskmanagement.components.usermanagement.IUserService;
import com.taskmanagement.components.usermanagement.UserService;
import com.taskmanagement.core.repositories.ITaskRepository;
import com.taskmanagement.core.repositories.IUserRepository;
import com.taskmanagement.infra.db.InMemoryTaskRepository;
import com.taskmanagement.infra.db.InMemoryUserRepository;
import com.taskmanagement.core.domain.User;
import com.taskmanagement.core.domain.Task;
import java.util.UUID;

/**
 *
 * @author educm
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Gestão de Tarefas (Componentizado)");

        // --- FASE DE COMPOSIÇÃO (Injeção de Dependência Manual) ---
        // O Main é o único lugar que conhece as classes CONCRETAS.
        
        // 1. Inicializa repositórios (Infraestrutura)
        IUserRepository userRepository = new InMemoryUserRepository();
        ITaskRepository taskRepository = new InMemoryTaskRepository();

        // 2. Inicializa componentes reutilizáveis (Tem duas implementações possíveis para notification)
        INotificationService notificationService = new EmailNotificationService();
//        INotificationService notificationService = new SmsNotificationService();
        IUserService userService = new UserService(userRepository);

        // 3. Inicializa o componente principal, injetando os outros
        ITaskService taskService = new TaskService(
            taskRepository, 
            userService, 
            notificationService
        );

        // --- FIM DA COMPOSIÇÃO ---
        
        // --- FASE DE EXECUÇÃO ---
        // A partir daqui, usamos apenas as INTERFACES.
        
        System.out.println("\nCriando usuário...");
        // (Adicionando um usuário manualmente ao repo para o teste)
        User user = new User(UUID.randomUUID(), "Ana", "ana@email.com", "55912345678"); // (supostamente viria de userService.createUser...)
        ((InMemoryUserRepository) userRepository).save(user); // Cast para popular
        
        System.out.println("Usuário 'Ana' criado.");

        System.out.println("\nCriando nova tarefa...");
        Task novaTarefa = taskService.createTask(
            "Implementar Diagrama UML", 
            "Usar uma ferramenta online para...", 
            user.getId()
        );
        
        System.out.println("Tarefa criada com sucesso: " + novaTarefa.getTitle());
    }
}
