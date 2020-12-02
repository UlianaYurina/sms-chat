package org.com.chat.service;


import org.com.chat.dao.UserDao;
import org.com.chat.dao.impl.HibernateUserDao;
import org.com.chat.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewUserServiceImpl implements NewUserService {


    @Override
    public User newUser(String loginNew) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UserDao userDao = new HibernateUserDao();

        System.out.println("Your login: " + loginNew);

        System.out.println("Enter first name:");
        String firstName = reader.readLine();

        System.out.println("Enter last name:");
        String lastName = reader.readLine();

        System.out.println("Enter password:");
        String password = reader.readLine();

        return userDao.createUser(loginNew, firstName, lastName, password);
    }
}
