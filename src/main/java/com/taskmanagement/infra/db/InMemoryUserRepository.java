/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanagement.infra.db;

import com.taskmanagement.core.domain.User;
import com.taskmanagement.core.repositories.IUserRepository;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author educm
 */

/**
 * Implementação EM MEMÓRIA do repositório de usuários.
 * Simula um banco de dados para fins de teste e demonstração.
 */
public class InMemoryUserRepository implements IUserRepository {
    // Simula a tabela do banco de dados (Chave: ID do Usuário, Valor: Objeto User)
    private final Map<UUID, User> userDatabase = new ConcurrentHashMap<>();

    /**
     * Método público para "popular" o banco de dados em memória.
     * Isso não faz parte da interface IUserRepository, mas é útil 
     * para o Main.java configurar o ambiente.
     */
    public User save(User user) {
        userDatabase.put(user.getId(), user);
        return user;
    }

    /**
     * Implementação do método da interface.
     */
    public User findById(UUID id) {
        // Retorna o usuário do "banco" ou null se não for encontrado
        return userDatabase.get(id);
    }
}
