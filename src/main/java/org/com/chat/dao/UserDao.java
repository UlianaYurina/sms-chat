package org.com.chat.dao;

import org.com.chat.domain.User;

import java.util.Collection;

public interface UserDao {
    User createUser(String login, String firstName, String lastName);
    Collection<User> findAllUsers();
    User findUserByLogin(String login);
    User removeUser(Integer id); // doesnt work
}
